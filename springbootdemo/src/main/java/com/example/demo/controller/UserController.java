package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.exception.UserNotFoundException;
import com.example.demo.model.User;
import com.example.demo.service.UserService;

@RestController
public class UserController {

	@Autowired
	private UserService userservice;

	public UserController(@Autowired UserService userservice) {
		super();
		this.userservice = userservice;
	}
	
	@PostMapping("/user")
	public User newUser(@RequestBody User user)
	{
		return userservice.save(user);
	}
	
	@PutMapping("/user")
	public User updateUser(@RequestBody User user)
	{
		return userservice.save(user);
	}
	
	@GetMapping("/user/{userId}")
	public User getUser(@PathVariable int userId)  throws UserNotFoundException
	{
		return userservice.getUser(userId);
	}
	
	@GetMapping("/users")
	public List<User> findAllUsers()
	{
		return userservice.findAll();
	}
	
	@DeleteMapping("/user/{userId}")
	public String deleteUser(@PathVariable int userId) throws UserNotFoundException
	{
		userservice.delete(userId);
		return "deleteUserById" +userId ;
	}
}


