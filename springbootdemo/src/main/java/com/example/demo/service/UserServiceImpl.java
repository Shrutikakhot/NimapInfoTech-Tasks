package com.example.demo.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.exception.UserNotFoundException;
import com.example.demo.model.User;
import com.example.demo.repository.UserRepository;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private UserRepository userrepo;
	
	
	public UserServiceImpl(@Autowired UserRepository userrepo) {
		super();
		this.userrepo = userrepo;
	}

	@Override
	public User save(User user) {
		return userrepo.save(user);
	}

	@Override
	public User getUser(int userId) throws UserNotFoundException {
		//if -else
		Optional<User> user=userrepo.findById(userId);
		User u;
		if(user!=null && user.isPresent()){
		u= user.get();
		
	}
		else
		{
			throw new UserNotFoundException("User Not Found" +userId);
		}
		return u;
}

	@Override
	public void delete(int userId) throws UserNotFoundException {
	
		if(userrepo.existsById(userId))
		{
			userrepo.deleteById(userId) ;
		}
		else
		{
			throw new UserNotFoundException("User Id not found" +userId);
		}
	}

	@Override
	public List<User> findAll() {
		// TODO Auto-generated method stub
		return userrepo.findAll();
	}

}
