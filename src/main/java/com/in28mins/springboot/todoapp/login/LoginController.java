package com.in28mins.springboot.todoapp.login;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;

@Controller
@SessionAttributes("name")
public class LoginController {
	
	private LoginAuthenticationService loginAuthenticationService;
	
	public LoginController(LoginAuthenticationService loginAuthenticationService) {
		super();
		this.loginAuthenticationService = loginAuthenticationService;
	}

	Logger logger = LoggerFactory.getLogger(getClass());
	
	@RequestMapping(value = "login", method = RequestMethod.GET)
	public String login() {
		return "login";
	}
	
	@RequestMapping(value = "login", method = RequestMethod.POST)
	public String welcome(@RequestParam String name, @RequestParam String password, ModelMap model) {
		if(loginAuthenticationService.isValid(name, password)) {
			model.put("name", name);
			model.put("password", password);
			return "welcome";
		}
		else {
			model.put("error","Invalid Credentials !! Please try again");
			return "login";
		}

	}
}
