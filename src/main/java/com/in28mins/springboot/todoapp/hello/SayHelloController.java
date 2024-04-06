package com.in28mins.springboot.todoapp.hello;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class SayHelloController {
	
	Logger logger = LoggerFactory.getLogger(getClass());
	
	@RequestMapping("say-hello")
	@ResponseBody
	public String sayHello() {
		logger.info("Entering the sayHello Controller");
		return "Hello! What are you learning today ?";
	}
	
	@RequestMapping("say-hello-jsp")
	//@ResponseBody
	public String sayHelloHtml() {
		logger.info("Entering the sayHelloHtml Controller");
		return "sayHello";
	}

}
