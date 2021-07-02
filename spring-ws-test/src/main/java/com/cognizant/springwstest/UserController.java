package com.cognizant.springwstest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api")
public class UserController {
	
	@Autowired
	UserService service;

	@GetMapping("{name}")
	public String greetName(@PathVariable String name) {
		return "Hello "+name;
	}
	
	@GetMapping("user/{id}")
	public User findUser(@PathVariable int id) {
		return service.findUser(id);
	}
	
	@PostMapping(consumes=MediaType.APPLICATION_JSON_VALUE)
	public User addUser(@RequestBody User user) {
		return service.addUser(user);
	}
}
