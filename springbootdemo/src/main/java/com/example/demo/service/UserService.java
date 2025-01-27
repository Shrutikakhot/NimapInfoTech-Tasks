package com.example.demo.service;

import java.util.List;

import com.example.demo.exception.UserNotFoundException;
import com.example.demo.model.User;

public interface UserService {

	User save(User user);
	
	User getUser(int userId) throws UserNotFoundException ;
	
	void delete(int userId) throws UserNotFoundException;
	
	List<User> findAll();
}
