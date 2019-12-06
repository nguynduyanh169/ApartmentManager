package com.manager.controller;

import java.util.ArrayList;
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
import com.manager.dto.HouseDTO;
import com.manager.dto.UserDTO;
import com.manager.entity.House;
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

	@GetMapping("/users/{userId}")
	public ResponseEntity<?> findUserById(@PathVariable(value = "userId") long id) throws Exception {
		Optional<User> opUser = userService.findUserById(id);
		if (!opUser.isPresent()) {
			return new ResponseEntity<APIResponse>(new APIResponse(false, "Not found!"), HttpStatus.NO_CONTENT);
		} else {
			UserDTO userDTO = new UserDTO();
			User user = opUser.get();
			userDTO.setUserId(user.getUserId());
			userDTO.setEmail(user.getEmail());
			userDTO.setPhoneNo(user.getPhoneNo());
			House house = user.getHouse();
			HouseDTO houseDTO = new HouseDTO(house.getHouseId(), house.getHouseName());
			userDTO.setHouse(houseDTO);
			userDTO.setDateOfBirth(user.getDateOfBirth());
			userDTO.setProfileImage(user.getProfileImage());
			userDTO.setIdNumber(user.getIdNumber());
			userDTO.setGender(user.getGender());
			userDTO.setHomeTown(user.getHomeTown());
			userDTO.setJob(user.getJob());
			userDTO.setFirstName(user.getFirstName());
			userDTO.setLastName(user.getLastName());
			userDTO.setFamilyLevel(user.getFamilyLevel());
			return new ResponseEntity<UserDTO>(userDTO, HttpStatus.OK);
		}
	}

	@GetMapping("/users/houses/{houseId}")
	public List<UserDTO> getUserByHouseId(@PathVariable(value = "houseId") long houseId) {
		List<User> users = userService.getUserByHouseId(houseId);
		List<UserDTO> userDTOs = new ArrayList<UserDTO>();
		for (User user : users) {
			UserDTO userDTO = new UserDTO();
			userDTO.setUserId(user.getUserId());
			userDTO.setEmail(user.getEmail());
			userDTO.setPhoneNo(user.getPhoneNo());
			House house = user.getHouse();
			HouseDTO houseDTO = new HouseDTO(house.getHouseId(), house.getHouseName());
			userDTO.setHouse(houseDTO);
			userDTO.setDateOfBirth(user.getDateOfBirth());
			userDTO.setProfileImage(user.getProfileImage());
			userDTO.setIdNumber(user.getIdNumber());
			userDTO.setGender(user.getGender());
			userDTO.setHomeTown(user.getHomeTown());
			userDTO.setJob(user.getJob());
			userDTO.setFirstName(user.getFirstName());
			userDTO.setLastName(user.getLastName());
			userDTO.setFamilyLevel(user.getFamilyLevel());
			userDTOs.add(userDTO);
		}
		return userDTOs;
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

	@PutMapping("/users/{userId}")
	public ResponseEntity<?> updateUser(@PathVariable(value = "userId") long id, @Valid @RequestBody User editUser)
			throws Exception {
		Optional<User> opUser = userService.findUserById(id);
		if (!opUser.isPresent()) {
			return new ResponseEntity<User>(opUser.get(), HttpStatus.NO_CONTENT);
		}
		User user = opUser.get();
		user.setRole(editUser.getRole());
		user.setHouse(editUser.getHouse());
		user.setProfileImage(editUser.getProfileImage());
		user.setFirstName(editUser.getFirstName());
		user.setLastName(editUser.getLastName());
		user.setJob(editUser.getJob());
		user.setHomeTown(editUser.getHomeTown());
		user.setPhoneNo(editUser.getPhoneNo());
		user.setDateOfBirth(editUser.getDateOfBirth());
		user.setFamilyLevel(editUser.getFamilyLevel());
		user.setIdNumber(editUser.getIdNumber());
		user.setIdImage(editUser.getIdImage());
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
		boolean flag = userService.checkLogin(email);
		if (flag == false) {
			return new ResponseEntity<APIResponse>(new APIResponse(false, "Login Failed!"),
					HttpStatus.BAD_REQUEST);
		} else {
			return new ResponseEntity<APIResponse>(new APIResponse(true, "Login successful!"), HttpStatus.OK);
		}
	}

	@DeleteMapping("/users/{userId}")
	public ResponseEntity<String> removeUser(@PathVariable(value = "userId") long id) throws Exception {
		userService.removeUser(id);
		return new ResponseEntity<String>("Deleted!", HttpStatus.OK);
	}

}
