package com.manager.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.manager.entity.User;

@Service
public interface UserService {
	public List<User> getAllUser();

	public List<User> getUserByHouseId(long houseId);

	public Optional<User> findUserById(long id);

	public boolean saveUser(User user);

	public long countUser();

	public void removeUser(long id);
	
	public boolean checkLogin(String email, String password);
	
	public boolean checkUsername(String username);
	
	public boolean checkUserEmail(String email);
}
