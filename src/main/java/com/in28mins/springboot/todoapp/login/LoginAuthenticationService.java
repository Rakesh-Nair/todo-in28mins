package com.in28mins.springboot.todoapp.login;

import org.springframework.stereotype.Service;

@Service
public class LoginAuthenticationService {

	public boolean isValid(String user, String password) {
		return user.equalsIgnoreCase("user") && password.equalsIgnoreCase("pass");
	}
}
