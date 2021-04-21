package com.javaexpress.org.service;



import java.util.List;

import com.javaexpress.org.model.User;


public interface UserService {
	public User createUser(User user);
	public void updateUser(Long id, User user);
	public void deleteUser(Long id);
	public List<User>getAllUsers();

}
