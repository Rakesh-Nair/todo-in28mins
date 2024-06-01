package com.in28mins.springboot.todoapp;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

import org.springframework.stereotype.Service;

@Service
public class TodoService {
	public static final List<Todo> todos;
	public static int count = 0;
	static {
		//int id, String description, String username, LocalDate targetDate, boolean done
		todos = new ArrayList<>();
		Todo todo = new Todo(++count, "Learn AWS Certified", "Rakesh", LocalDate.now().plusDays(1), false);
		todos.add(todo);
		todo = new Todo(++count, "Learn GWT in Detail", "Rakesh", LocalDate.now().plusDays(1), false);
		todos.add(todo);
		todo = new Todo(++count, "Learn Angular", "Ramita", LocalDate.now().plusDays(1), false);
		todos.add(todo);
		todo = new Todo(++count, "Learn React", "Rakesh", LocalDate.now().plusDays(1), false);
		todos.add(todo);
		todo = new Todo(++count, "Learn Jenkins", "Rakesh", LocalDate.now().plusDays(1), false);
		todos.add(todo);
		todo = new Todo(++count, "Learn Google Cloud", "Rakesh", LocalDate.now().plusDays(1), false);
		todos.add(todo);
		todo = new Todo(++count, "Learn Google Security", "Rishaan", LocalDate.now().plusDays(1), false);
		todos.add(todo);
	}
	
	
	
	public List<Todo> getAllTodos(String username) {
		Predicate<? super Todo> predicate = t -> t.getUsername().equalsIgnoreCase(username);
		return this.todos.stream().filter(predicate).toList();
	}
	
	public void addTodo(String name, String description, LocalDate date, boolean done) {
		Todo todo = new Todo(++count, description, name, date, done);
		todos.add(todo);
	}

	public void deleteTodo(int id) {
		Predicate<? super Todo> predicate = todo -> todo.getId() == id;
		todos.removeIf(predicate);
	}

	public Todo findTodoById(int id) {
		Predicate<? super Todo> predicate = todo -> todo.getId() == id;
		return todos.stream().filter(predicate).findFirst().get();
	}

	public void updateTodo(Todo todo) {
		Todo fetchedTodo = todos.stream().filter(t -> t.getId() == todo.getId()).findFirst().get();
		fetchedTodo.setDescription(todo.getDescription());
		fetchedTodo.setDone(todo.isDone());
		fetchedTodo.setTargetDate(todo.getTargetDate());
	}

}
