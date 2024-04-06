package com.in28mins.springboot.todoapp;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

@Service
public class TodoService {
	public static final List<Todo> todos;
	static {
		//int id, String description, String username, LocalDate targetDate, boolean done
		todos = new ArrayList<>();
		Todo todo = new Todo(1, "Learn AWS", "Rakesh", LocalDate.now().plusDays(1), false);
		todos.add(todo);
		todo = new Todo(2, "Learn GWT", "Rakesh", LocalDate.now().plusDays(1), false);
		todos.add(todo);
		todo = new Todo(3, "Learn Angular", "Rakesh", LocalDate.now().plusDays(1), false);
		todos.add(todo);
		todo = new Todo(4, "Learn React", "Rakesh", LocalDate.now().plusDays(1), false);
		todos.add(todo);
		todo = new Todo(5, "Learn Jenkins", "Rakesh", LocalDate.now().plusDays(1), false);
		todos.add(todo);
		todo = new Todo(6, "Learn AWS", "Rakesh", LocalDate.now().plusDays(1), false);
		todos.add(todo);
	}
	
	
	
	public List<Todo> findByUsername(String name) {
		return this.todos;
	}

}
