package com.manager.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.manager.entity.User;
import com.manager.repository.UserRepository;
@Service
public class UserServiceImpl implements UserService{

	@Autowired
	UserRepository userRepo;
	
	@Override
	public List<User> getAllUser() {
		List<User> userList = userRepo.findAll();
		return userList;
	}

	@Override
	public Optional<User> findUserById(long id) {
		Optional<User> user = userRepo.findById(id);
		return user;
	}

	@Override
	public User saveUser(User user) {
		return userRepo.save(user);
	}

	@Override
	public long countUser() {
		// TODO Auto-generated method stub
		return userRepo.count();
	}

}
