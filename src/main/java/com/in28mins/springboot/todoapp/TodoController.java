package com.in28mins.springboot.todoapp;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;

@Controller
@SessionAttributes("name")
public class TodoController {
	
	@Autowired
	private TodoService todoService;

	@RequestMapping(method = RequestMethod.GET, value = "list-todos")
	public String listAllTodos(ModelMap model) {
		List<Todo> todos = todoService.findByUsername("Rakesh");
		model.put("todos", todos);
		return "list-todos";
	}

	public TodoController(TodoService todoService) {
		super();
		this.todoService = todoService;
	}
	
	
}