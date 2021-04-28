package com.javaexpress.org.service;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.javaexpress.org.model.User;
import com.javaexpress.org.repo.UserRepository;
import com.web.exception.UserNotFoundException;
@Service
public class UserServiceImpl implements UserService {
	@Autowired
private UserRepository userRepo;
	@Override
	public User createUser(User user) {
		
		return userRepo.save(user);
	}
	@Override
	public void updateUser(Long id, User user) {
		Optional<User>userdetails=userRepo.findById(id);
		if(!userdetails.isPresent()) {
			System.out.println("l'utilisateur n'existe pas"+id);
			User dbUser=userdetails.get();
			dbUser.setId(user.getId());
			dbUser.setFirstName(user.getFirstName());
			dbUser.setEmail(user.getEmail());
			dbUser.setAge(user.getAge());
			userRepo.save(dbUser);
		}else {
			System.out.println("l'utilisateur n'existe pas"+id);
		}	
	}
	@Override
	public void deleteUser(Long id) {
		userRepo.deleteById(id);
		
	}
	@Override
	public List<User> getAllUsers() {
		List<User>user=new ArrayList<>();
		userRepo.findAll().forEach(user1->user.add(user1));
		return user;
	}
	@Override
	public User getUser(Long id) {
		Optional<User>optionalUser=userRepo.findById(id);
		if(!optionalUser.isPresent()) {
			throw new UserNotFoundException("l'utilisateur n'est pas disponible en ce moment");
		}
		return optionalUser.get();
	}
	

}
