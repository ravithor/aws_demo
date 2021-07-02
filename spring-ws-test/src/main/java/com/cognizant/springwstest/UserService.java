package com.cognizant.springwstest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {

	@Autowired
	UserRepository repository;
	
	public User findUser(int id) {
		return repository.getById(id);
	}
	
	public User addUser(User user) {
		return repository.save(user);
	}
}
