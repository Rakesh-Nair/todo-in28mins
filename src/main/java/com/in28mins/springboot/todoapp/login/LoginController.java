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

	Logger logger = LoggerFactory.getLogger(getClass());
	
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String welcomePage(ModelMap model) {
		model.put("name", "Rakesh");
		return "welcome";
	}
}
