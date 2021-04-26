package com.javaexpress.org.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.javaexpress.org.model.User;
import com.javaexpress.org.service.UserService;




@RestController
@RequestMapping(value = "/api/v1")
public class UserController {
	@Autowired
	private UserService userService;
	
	@GetMapping(value = "/users")
	public List<User>getAllUser(){
		return userService.getAllUsers();
	}
	@PostMapping( value = "/users")
    public User createUser(@Valid @RequestBody User user) {
        return userService.createUser(user);
    }
	@PutMapping(value = "/users/{id}")
	public void updateUser(@PathVariable(name = "id")Long id, @ Valid @RequestBody User user) {
		userService.updateUser(id, user);
	}
	@DeleteMapping(value = "/users/{id}")
	public void deleteUser(@PathVariable(name = "id")Long id) {
		userService.deleteUser(id);
	}
	
}
