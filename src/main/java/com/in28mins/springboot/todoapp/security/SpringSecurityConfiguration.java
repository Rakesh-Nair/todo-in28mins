package com.in28mins.springboot.todoapp.security;

import java.util.function.Function;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;

@Configuration
public class SpringSecurityConfiguration {

	InMemoryUserDetailsManager manager;

	@Bean
	public InMemoryUserDetailsManager createUserDetailsManager() {
		
		UserDetails userDetails = createNewUser("rakesh123", "rakesh");
		UserDetails userDetails1 = createNewUser("rakesh123", "rishaan");
		UserDetails userDetails2 = createNewUser("rakesh123", "ramita");
		
		return new InMemoryUserDetailsManager(userDetails, userDetails1, userDetails2);
	}

	private UserDetails createNewUser(String password, String username) {
		Function<String, String> passwordEncoder = input -> passwordEncoder().encode(input);
		UserDetails userDetails = User.builder().passwordEncoder(passwordEncoder )
		.password(password)
		.username(username)
		.roles("USER", "ADMIN")
		.build();
		return userDetails;
	}
	
	@Bean
	public PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}
}
