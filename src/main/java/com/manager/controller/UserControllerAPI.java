package com.manager.controller;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.manager.entity.User;
import com.manager.service.UserService;

@RestController
@RequestMapping("api/v1")
@ComponentScan(basePackages = "com.manager.service")
public class UserControllerAPI {
	
	@Autowired
	UserService userService;
	
	@GetMapping("/users")
	public List<User> getAllUser(){
		return userService.getAllUser();
	}
	
	@GetMapping("/users/{id}")
	public ResponseEntity<User> findUserById(@PathVariable(value = "id") long id) throws Exception{
		Optional<User> user = userService.findUserById(id);
		if(!user.isPresent()) {
			return new ResponseEntity<User>(user.get(), HttpStatus.NO_CONTENT);
		}
		return new ResponseEntity<User>(user.get(), HttpStatus.OK);
	}
	
	@PostMapping("/users")
	public User saveUser(@Valid @RequestBody User user) {
		return userService.saveUser(user);
	}
	
	@GetMapping("/users/count")
	public long countUser() {
		return userService.countUser();
	}
	
	@PutMapping("/users/{id}")
	public ResponseEntity<User> updateUser(@PathVariable(value = "id") long id, @Valid @RequestBody User editUser) throws Exception{
		Optional<User> opUser = userService.findUserById(id);
		if(!opUser.isPresent()) {
			return new ResponseEntity<User>(opUser.get(), HttpStatus.NO_CONTENT);
		}
		User user = opUser.get();
		user.setUsername(editUser.getUsername());
		user.setRoleId(editUser.getRoleId());
		user.setHouseId(editUser.getHouseId());
		user.setCreator(editUser.getCreator());
		user.setProfileImage(editUser.getProfileImage());
		user.setDateOfBirth(editUser.getDateOfBirth());
		user.setCreateDate(editUser.getCreateDate());
		user.setFamilyLevel(editUser.getFamilyLevel());
		user.setStatus(editUser.getStatus());
		user.setIdCreatedDate(editUser.getIdCreatedDate());
		user.setSendPasswordTo(editUser.getSendPasswordTo());
		final User updatedUser = userService.saveUser(user);
		return new ResponseEntity<User>(user, HttpStatus.OK);
		
		
	}
	
	@DeleteMapping("/users/{id}")
	public ResponseEntity<String> removeUser(@PathVariable(value = "id") long id) throws Exception{
		userService.removeUser(id);
		return new ResponseEntity<String>("Deleted!", HttpStatus.OK);
	}

}
