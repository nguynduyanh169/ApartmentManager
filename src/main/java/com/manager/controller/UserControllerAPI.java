package com.manager.controller;

import java.io.IOException;
import com.manager.ApartmentManager.ParseDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.manager.dto.APIResponse;
import com.manager.dto.BlockDTO;
import com.manager.dto.HouseDTO;
import com.manager.dto.UserDTO;
import com.manager.dto.UserFullNameDTO;
import com.manager.dto.UserLoginDTO;
import com.manager.entity.House;
import com.manager.entity.User;
import com.manager.service.FCMService;
import com.manager.service.JwtService;
import com.manager.service.UserService;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import org.springframework.http.MediaType;

@RestController
@RequestMapping("api/v1")
@ComponentScan(basePackages = "com.manager.service")
@ComponentScan(basePackages = "com.manager.security")
public class UserControllerAPI {

	final String FOLDER_PATH = "src/main/resources/images";
	final String JPEG = "JPEG";
	final String PNG = "PNG";
	final String GIF = "GIF";
	ParseDate parse;

	@Autowired
	UserService userService;

	@Autowired
	JwtService jwtService;

	@Autowired
	private FCMService fcmService;

	@GetMapping("/users")
	public ResponseEntity<List<UserDTO>> getAllUser() {
		System.out.println("aasbfs");
		List<UserDTO> userDTOs = new ArrayList<UserDTO>();
		List<User> users = userService.getAllUser();
		for (User user : users) {
			UserDTO userDTO = new UserDTO();
			userDTO.setUserId(user.getUserId());
			userDTO.setEmail(user.getEmail());
			userDTO.setPhoneNo(user.getPhoneNo());
			House house = user.getHouse();
			//BlockDTO block = new BlockDTO(house.getBlock().getBlockId(), house.getBlock().getBlockName());
			//HouseDTO houseDTO = new HouseDTO(house.getHouseId(), house.getHouseName(), house.getOwnerId(),
			//	house.getCurrentMoney(), block);
			//userDTO.setHouse(houseDTO);
			parse = new ParseDate();
			userDTO.setDateOfBirth(parse.parseDateToString(user.getDateOfBirth()));
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
		return new ResponseEntity<List<UserDTO>>(userDTOs, HttpStatus.OK);
	}

	@GetMapping("/users/{userId}")
	public ResponseEntity<?> findUserById(@PathVariable(value = "userId") long userId) throws Exception {
		Optional<User> opUser = userService.findUserById(userId);
		if (!opUser.isPresent()) {
			return new ResponseEntity<APIResponse>(new APIResponse(false, "Not found!"), HttpStatus.NO_CONTENT);
		} else {
			UserDTO userDTO = new UserDTO();
			User user = opUser.get();
			userDTO.setUserId(user.getUserId());
			userDTO.setEmail(user.getEmail());
			userDTO.setPhoneNo(user.getPhoneNo());
			House house = user.getHouse();
			//BlockDTO block = new BlockDTO(house.getBlock().getBlockId(), house.getBlock().getBlockName());
			//HouseDTO houseDTO = new HouseDTO(house.getHouseId(), house.getHouseName(), house.getOwnerId(),
			//	house.getCurrentMoney(), block);
			//userDTO.setHouse(houseDTO);
			parse = new ParseDate();
			userDTO.setDateOfBirth(parse.parseDateToString(user.getDateOfBirth()));
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
			BlockDTO block = new BlockDTO(house.getBlock().getBlockId(), house.getBlock().getBlockName());
			HouseDTO houseDTO = new HouseDTO(house.getHouseId(), house.getHouseName(), house.getOwnerId(),
					house.getCurrentMoney(), block);
			userDTO.setHouse(houseDTO);
			parse = new ParseDate();
			userDTO.setDateOfBirth(parse.parseDateToString(user.getDateOfBirth()));
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
			fcmService.pushNotificationByTopic(user.getEmail(), "Register", user.getEmail());
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
		user.setEmail(editUser.getEmail());
		user.setRole(editUser.getRole());
		user.setHouse(editUser.getHouse());
		user.setFirstName(editUser.getFirstName());
		user.setLastName(editUser.getLastName());
		user.setJob(editUser.getJob());
		user.setHomeTown(editUser.getHomeTown());
		user.setPhoneNo(editUser.getPhoneNo());
		user.setDateOfBirth(editUser.getDateOfBirth());
		user.setFamilyLevel(editUser.getFamilyLevel());
		user.setIdNumber(editUser.getIdNumber());
		boolean flag = userService.saveUser(user);
		if (flag == false) {
			return new ResponseEntity<APIResponse>(new APIResponse(false, "Save failed!"), HttpStatus.BAD_REQUEST);
		} else {
			return new ResponseEntity<APIResponse>(new APIResponse(true, "Save successful!"), HttpStatus.OK);
		}
	}

	@PostMapping("/users/signin")
	public ResponseEntity<String> login(HttpServletRequest request, @Valid @RequestBody User user) {
		String result = "";
		HttpStatus httpStatus = null;
		System.out.println(result + "aaaa");
		try {
			if (userService.checkLogin(user.getEmail(), user.getPassword()) != null) {
				result = jwtService.generateTokenLogin(user.getEmail());
				httpStatus = HttpStatus.OK;
			} else {
				result = "Wrong userId and password";
				httpStatus = HttpStatus.BAD_REQUEST;
			}
		} catch (Exception ex) {
			result = "Server Error";
			httpStatus = HttpStatus.INTERNAL_SERVER_ERROR;
		}
		return new ResponseEntity<String>(result, httpStatus);
	}

	@DeleteMapping("/users/{userId}")
	public ResponseEntity<String> removeUser(@PathVariable(value = "userId") long id) throws Exception {
		userService.removeUser(id);
		return new ResponseEntity<String>("Deleted!", HttpStatus.OK);
	}

	@GetMapping("/users/email/{email}")
	public ResponseEntity<?> checkUserEmail(@PathVariable(value = "email") String email) {
		User user = userService.checkUserEmail(email);
		if (user == null) {
			return new ResponseEntity<APIResponse>(new APIResponse(false, "Email not available!"),
					HttpStatus.BAD_REQUEST);
		} else {
			return new ResponseEntity<APIResponse>(new APIResponse(true, "Email has been existed!"), HttpStatus.OK);
		}
	}

	
}
