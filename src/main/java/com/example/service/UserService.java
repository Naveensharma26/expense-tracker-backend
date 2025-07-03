package com.example.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.model.User;
import com.example.repository.UserRepository;

@Service
public class UserService {
	
	@Autowired
	UserRepository repo;
	
	public List<User> getAllUsers(){
		return repo.findAll();
	}
	
	public User registerUser(User u) {
		return repo.save(u);
	}
	
	public User getUserById(int id) {
		return repo.findById(id).orElse(null);
	}

	
}
