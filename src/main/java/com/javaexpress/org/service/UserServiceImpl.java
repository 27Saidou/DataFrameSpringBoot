package com.javaexpress.org.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.javaexpress.org.model.User;
import com.javaexpress.org.repo.UserRepository;
@Service
public class UserServiceImpl implements UserService {
	@Autowired
private UserRepository userRepo;
	@Override
	public User createUser(User user) {
		
		return userRepo.save(user);
	}

}
