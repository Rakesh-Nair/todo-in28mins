package com.in28mins.springboot.todoapp;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;

import jakarta.validation.Valid;

@Controller
@SessionAttributes("name")
public class TodoController {
	
	@Autowired
	private TodoService todoService;

	@RequestMapping(method = RequestMethod.GET, value = "list-todos")
	public String listAllTodos(ModelMap model) {
		List<Todo> todos = todoService.getAllTodos();
		model.put("todos", todos);
		return "list-todos";
	}

	public TodoController(TodoService todoService) {
		super();
		this.todoService = todoService;
	}
	
	@RequestMapping(method = RequestMethod.GET, value = "add-todo")
	public String addTodoPage(ModelMap model) {
		String user = (String) model.get("user");
		Todo todo = new Todo(0, user, "", LocalDate.now(), false);
		model.addAttribute("todo", todo);
		return "add-todo";
	}
	
	@RequestMapping(method = RequestMethod.POST, value = "add-todo")
	public String listTodosPage(ModelMap model, @Valid Todo todo, BindingResult result) {
		if(result.hasErrors()) {
			return "add-todo";
		}
		String user = (String) model.get("user");
		todoService.addTodo(user, todo.getDescription(), todo.getTargetDate(), false);
		return "redirect:list-todos";
	}
	
	@RequestMapping(method = RequestMethod.GET, value = "delete-todo")
	public String deleteTodo(@RequestParam int id) {
		todoService.deleteTodo(id);
		return "redirect:list-todos";
	}
	
	@RequestMapping(method = RequestMethod.GET, value = "update-todo")
	public String updateTodo(@RequestParam int id, ModelMap model) {
		String user = (String) model.get("user");
		Todo todo = todoService.findTodoById(id);
		model.addAttribute("todo", todo);
		return "add-todo";
	}
	
	@RequestMapping(method = RequestMethod.POST, value = "update-todo")
	public String updateTodosPage(ModelMap model, @Valid Todo todo, BindingResult result) {
		if(result.hasErrors()) {
			return "add-todo";
		}
		todoService.updateTodo(todo);
		return "redirect:list-todos";
	}
	
}
