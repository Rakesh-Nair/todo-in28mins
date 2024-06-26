package com.in28mins.springboot.todoapp;

import java.time.LocalDate;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.validation.constraints.Size;

@Entity
public class Todo {
	
	@Id
	@GeneratedValue
	private int id;
	
	@Size(min = 10, message = "Enter atleast 10 Characters")
	private String description;
	private String username;
	private LocalDate targetDate;
	private boolean done;
	
	public Todo() {
		super();
		// TODO Auto-generated constructor stub
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public LocalDate getTargetDate() {
		return targetDate;
	}
	public void setTargetDate(LocalDate targetDate) {
		this.targetDate = targetDate;
	}
	public boolean isDone() {
		return done;
	}
	public void setDone(boolean done) {
		this.done = done;
	}
	
	@Override
	public String toString() {
		return "Todo [id=" + id + ", description=" + description + ", username=" + username + ", targetDate="
				+ targetDate + ", done=" + done + "]";
	}
	
	public Todo(int id, String description, String username, LocalDate targetDate, boolean done) {
		super();
		this.id = id;
		this.description = description;
		this.username = username;
		this.targetDate = targetDate;
		this.done = done;
	}
}
