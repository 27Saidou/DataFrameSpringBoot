package com.javaexpress.org.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
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
	
	@PostMapping( value = "/users")
    public User createUser(@Valid @RequestBody User user) {
        return userService.createUser(user);
    }
}
