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

import com.manager.dto.APIResponse;
import com.manager.entity.User;
import com.manager.service.UserService;

@RestController
@RequestMapping("api/v1")
@ComponentScan(basePackages = "com.manager.service")
public class UserControllerAPI {

	@Autowired
	UserService userService;

	@GetMapping("/users")
	public List<User> getAllUser() {
		return userService.getAllUser();
	}

	@GetMapping("/users/{id}")
	public ResponseEntity<?> findUserById(@PathVariable(value = "id") long id) throws Exception {
		Optional<User> user = userService.findUserById(id);
		if (!user.isPresent()) {
			return new ResponseEntity<APIResponse>(new APIResponse(false, "Not found!"), HttpStatus.NO_CONTENT);
		} else {
			return new ResponseEntity<User>(user.get(), HttpStatus.OK);
		}
	}

	@GetMapping("/users/houses/{houseId}")
	public List<User> getUserByHouseId(@PathVariable(value = "houseId") long houseId) {
		return userService.getUserByHouseId(houseId);
	}

	@PostMapping("/users")
	public ResponseEntity<?> saveUser(@Valid @RequestBody User user) {
		boolean flag = userService.saveUser(user);
		if (flag == false) {
			return new ResponseEntity<APIResponse>(new APIResponse(false, "Save failed!"), HttpStatus.BAD_REQUEST);
		} else {
			return new ResponseEntity<APIResponse>(new APIResponse(true, "Save successful!"), HttpStatus.OK);
		}

	}

	@GetMapping("/users/count")
	public long countUser() {
		return userService.countUser();
	}

	@PutMapping("/users/{id}")
	public ResponseEntity<?> updateUser(@PathVariable(value = "id") long id, @Valid @RequestBody User editUser)
			throws Exception {
		Optional<User> opUser = userService.findUserById(id);
		if (!opUser.isPresent()) {
			return new ResponseEntity<User>(opUser.get(), HttpStatus.NO_CONTENT);
		}
		User user = opUser.get();
		user.setUsername(editUser.getUsername());
		user.setRole(editUser.getRole());
		user.setHouse(editUser.getHouse());
		user.setCreator(editUser.getCreator());
		user.setProfileImage(editUser.getProfileImage());
		user.setDateOfBirth(editUser.getDateOfBirth());
		user.setCreateDate(editUser.getCreateDate());
		user.setFamilyLevel(editUser.getFamilyLevel());
		user.setStatus(editUser.getStatus());
		user.setIdCreatedDate(editUser.getIdCreatedDate());
		boolean flag = userService.saveUser(user);
		if (flag == false) {
			return new ResponseEntity<APIResponse>(new APIResponse(false, "Save failed!"), HttpStatus.BAD_REQUEST);
		} else {
			return new ResponseEntity<APIResponse>(new APIResponse(true, "Save successful!"), HttpStatus.OK);
		}

	}

	@PutMapping("/users/{id}/password/{password}")
	public ResponseEntity<?> changePassword(@PathVariable(value = "id") long id,
			@PathVariable(name = "password") String password) throws Exception {
		Optional<User> opUser = userService.findUserById(id);
		if (!opUser.isPresent()) {
			return new ResponseEntity<User>(opUser.get(), HttpStatus.NO_CONTENT);
		}
		User user = opUser.get();
		user.setPassword(password);
		boolean flag = userService.saveUser(user);
		if (flag == false) {
			return new ResponseEntity<APIResponse>(new APIResponse(false, "Save failed!"), HttpStatus.BAD_REQUEST);
		} else {
			return new ResponseEntity<APIResponse>(new APIResponse(true, "Save successful!"), HttpStatus.OK);
		}
	}

	@PostMapping("/users/signin")
	public ResponseEntity<?> checkLogin(@Valid @RequestBody User user) {
		String email = user.getEmail();
		String password = user.getPassword();
		boolean flag = userService.checkLogin(email, password);
		if (flag == false) {
			return new ResponseEntity<APIResponse>(new APIResponse(false, "Username or Password is not valid!"),
					HttpStatus.BAD_REQUEST);
		} else {
			return new ResponseEntity<APIResponse>(new APIResponse(true, "Login successful!"), HttpStatus.OK);
		}
	}

	@DeleteMapping("/users/{id}")
	public ResponseEntity<String> removeUser(@PathVariable(value = "id") long id) throws Exception {
		userService.removeUser(id);
		return new ResponseEntity<String>("Deleted!", HttpStatus.OK);
	}

}
