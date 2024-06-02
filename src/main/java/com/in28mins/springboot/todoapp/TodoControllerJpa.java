package com.in28mins.springboot.todoapp;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
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
public class TodoControllerJpa {
	
	//@Autowired
	private TodoRepository todoRepository;

	@RequestMapping(method = RequestMethod.GET, value = "list-todos")
	public String listAllTodos(ModelMap model) {
		String user = getLoggedInUser(model);
		List<Todo> todos = todoRepository.findByUsername(user);
		model.put("todos", todos);
		return "list-todos";
	}

	public TodoControllerJpa(TodoRepository todoRepository) {
		super();
		this.todoRepository = todoRepository;
	}
	
	@RequestMapping(method = RequestMethod.GET, value = "add-todo")
	public String addTodoPage(ModelMap model) {
		String user = getLoggedInUser(model);
		Todo todo = new Todo(0, "", user, LocalDate.now(), false);
		model.addAttribute("todo", todo);
		return "add-todo";
	}
	
	@RequestMapping(method = RequestMethod.POST, value = "add-todo")
	public String listTodosPage(ModelMap model, @Valid Todo todo, BindingResult result) {
		if(result.hasErrors()) {
			return "add-todo";
		}
		String user = getLoggedInUser(model);
		todo.setUsername(user);
		todoRepository.save(todo);
		return "redirect:list-todos";
	}
	
	@RequestMapping(method = RequestMethod.GET, value = "delete-todo")
	public String deleteTodo(@RequestParam int id) {
		todoRepository.deleteById(id);
		return "redirect:list-todos";
	}
	
	@RequestMapping(method = RequestMethod.GET, value = "update-todo")
	public String updateTodo(@RequestParam int id, ModelMap model) {
		String user = getLoggedInUser(model);
		Todo todo = todoRepository.findById(id).get();
		model.addAttribute("todo", todo);
		return "add-todo";
	}
	
	@RequestMapping(method = RequestMethod.POST, value = "update-todo")
	public String updateTodosPage(ModelMap model, @Valid Todo todo, BindingResult result) {
		if(result.hasErrors()) {
			return "add-todo";
		}
		String user = getLoggedInUser(model);
		todo.setUsername(user);
		todoRepository.save(todo);
		return "redirect:list-todos";
	}
	
	private String getLoggedInUser(ModelMap model) {
		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		return authentication.getName();
	}
	
}
