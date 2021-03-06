package com.manager.controller;

import java.io.File;
import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
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
import com.manager.entity.House;
import com.manager.service.HouseService;

import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;

@RestController
@RequestMapping("/api/v1")
@ComponentScan(basePackages = "com.manager.service")
public class HouseControllerAPI {

	@Autowired
	HouseService houseService;

	@GetMapping("/houses/blocks/{blockId}")
	@ApiImplicitParams({
		@ApiImplicitParam(name = "Authorization", value = "Authorization token", required = true, dataType = "string", paramType = "header") })
	public List<House> getHouseByBlockId(@PathVariable(value = "blockId") long blockId) {
		return houseService.getHouseByBlockId(blockId);
	}

	@GetMapping("/houses/houseCategories/{typeId}")
	@ApiImplicitParams({
		@ApiImplicitParam(name = "Authorization", value = "Authorization token", required = true, dataType = "string", paramType = "header") })
	public List<House> getHouseByTypeId(@PathVariable(value = "typeId") long typeId) {
		return houseService.getHouseByTypeId(typeId);
	}

	@GetMapping("/houses/{houseId}")
	@ApiImplicitParams({
		@ApiImplicitParam(name = "Authorization", value = "Authorization token", required = true, dataType = "string", paramType = "header") })
	public ResponseEntity<House> getHouseById(@PathVariable(value = "houseId") long id) throws Exception {
		Optional<House> house = houseService.getHouseById(id);
		if (!house.isPresent()) {
			return new ResponseEntity<House>(house.get(), HttpStatus.NO_CONTENT);
		} else {

			return new ResponseEntity<House>(house.get(), HttpStatus.OK);
		}
	}

	@PostMapping("/houses")
	@ApiImplicitParams({
		@ApiImplicitParam(name = "Authorization", value = "Authorization token", required = true, dataType = "string", paramType = "header") })
	public ResponseEntity<?> saveHouse(@Valid @RequestBody House house) {
		boolean flag = houseService.save(house);
		if (flag == false) {
			return new ResponseEntity<APIResponse>(new APIResponse(false, "Save failed!"), HttpStatus.BAD_REQUEST);
		} else {
			return new ResponseEntity<APIResponse>(new APIResponse(true, "Save successful!"), HttpStatus.OK);
		}
	}

	@PutMapping("/houses/{houseId}")
	@ApiImplicitParams({
		@ApiImplicitParam(name = "Authorization", value = "Authorization token", required = true, dataType = "string", paramType = "header") })
	public ResponseEntity<?> updateHouse(@PathVariable(value = "houseId") long id,
			@Valid @RequestBody House updateHouse) throws Exception {
		Optional<House> opHouse = houseService.getHouseById(id);
		if (!opHouse.isPresent()) {
			return new ResponseEntity<House>(opHouse.get(), HttpStatus.NO_CONTENT);
		} else {
			House house = opHouse.get();
			house.setBlock(updateHouse.getBlock());
			house.setFloor(updateHouse.getFloor());
			house.setHouseName(updateHouse.getHouseName());
			house.setDescription(updateHouse.getDescription());
			house.setArea(updateHouse.getArea());
			house.setOwnerId(updateHouse.getOwnerId());
			house.setProfileImage(updateHouse.getProfileImage());
			house.setCoverImage(updateHouse.getCoverImage());
			house.setDisplayMember(updateHouse.isDisplayMember());
			house.setType(updateHouse.getType());
			house.setStatus(updateHouse.getStatus());
			house.setWaterMeter(updateHouse.getWaterMeter());
			boolean flag = houseService.save(house);
			if (flag == false) {
				return new ResponseEntity<APIResponse>(new APIResponse(false, "Save failed!"), HttpStatus.BAD_REQUEST);
			} else {
				return new ResponseEntity<APIResponse>(new APIResponse(true, "Save successful!"), HttpStatus.OK);
			}
		}

	}

	@PutMapping("/houses/{houseId}/currentMoney/{currentMoney}")
	@ApiImplicitParams({
		@ApiImplicitParam(name = "Authorization", value = "Authorization token", required = true, dataType = "string", paramType = "header") })
	public ResponseEntity<?> updateHouseWalletById(@PathVariable(value = "houseId") long id,
			@PathVariable(value = "currentMoney") long currentMoney) throws Exception {
		Optional<House> opHouse = houseService.getHouseById(id);
		if (!opHouse.isPresent()) {
			return new ResponseEntity<House>(opHouse.get(), HttpStatus.NO_CONTENT);
		} else {
			House house = opHouse.get();
			house.setCurrentMoney(currentMoney);
			boolean flag = houseService.save(house);
			if (flag == false) {
				return new ResponseEntity<APIResponse>(new APIResponse(false, "Save failed!"), HttpStatus.BAD_REQUEST);
			} else {
				return new ResponseEntity<APIResponse>(new APIResponse(true, "Save successful!"), HttpStatus.OK);
			}
		}

	}

	@GetMapping("/houses/count")
	@ApiImplicitParams({
		@ApiImplicitParam(name = "Authorization", value = "Authorization token", required = true, dataType = "string", paramType = "header") })
	public long countHouse() {
		return houseService.countHouse();
	}

	@DeleteMapping("/houses/{houseId}")
	@ApiImplicitParams({
		@ApiImplicitParam(name = "Authorization", value = "Authorization token", required = true, dataType = "string", paramType = "header") })
	public ResponseEntity<String> removeHouse(@PathVariable(value = "houseId") long id) throws Exception {
		houseService.removeHouse(id);
		return new ResponseEntity<String>("Deleted!", HttpStatus.OK);
	}
}
