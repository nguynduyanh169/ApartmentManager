package com.manager.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.manager.entity.User;
@Service
public interface UserService {
	public List<User> getAllUser();
	
	public Optional<User> findUserById(long id);
	
	public User saveUser(User user);
	
	public long countUser();
	
	public void removeUser(long id);
}
