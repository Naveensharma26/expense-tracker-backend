package com.example.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.model.User;
import com.example.service.UserService;

@RestController
@CrossOrigin
public class UserController {

	@Autowired
	UserService service;
	
	@GetMapping("/users")
	public List<User> getAllUsers(){
		return service.getAllUsers();
	}
	
	@PostMapping("/users")
	public User registerUser(@RequestBody User u) {
		return service.registerUser(u);
	}
	
	@GetMapping("/users/{id}")
	public User getUserById(@PathVariable int id) {
		return service.getUserById(id);
	}
	
}