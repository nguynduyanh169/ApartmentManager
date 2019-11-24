package com.manager.controller;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.manager.entity.House;
import com.manager.repository.HouseRepository;
import com.manager.service.HouseService;

@RestController
@RequestMapping("/api/v1")
@ComponentScan(basePackages = "com.manager.service")
public class HouseControllerAPI {
	
	@Autowired
	HouseService houseService;
	
	@GetMapping("/houses")
	public List<House> getAllHouse(){
		return houseService.getAllHouse();
	}
	
	@GetMapping("/houses/{id}")
	public ResponseEntity<House> getHouseById(@PathVariable(value = "id") long id) throws Exception{
		Optional<House> house = houseService.getHouseById(id);
		if(house == null) {
			return new ResponseEntity<House>(house.get(), HttpStatus.NO_CONTENT);
		}
		
		return new ResponseEntity<House>(house.get(), HttpStatus.OK);
	}
	
	@PostMapping("/houses")
	public House saveHouse(@Valid @RequestBody House house) {
		return houseService.save(house);
	}
	
	@PutMapping("/houses/{id}")
	public ResponseEntity<House> updateHouse(@PathVariable(value = "id") long id
			, @Valid @RequestBody House updateHouse) throws Exception{
		Optional<House> opHouse = houseService.getHouseById(id);
		if(!opHouse.isPresent()) {
			return new ResponseEntity<House>(opHouse.get(), HttpStatus.NO_CONTENT);
		}
		House house = opHouse.get();
		System.out.println(house.getHouseName());
		house.setBlockId(updateHouse.getBlockId());
		house.setFloor(updateHouse.getFloor());
		house.setHouseName(updateHouse.getHouseName());
		house.setDescription(updateHouse.getDescription());
		house.setArea(updateHouse.getArea());
		house.setOwnerId(updateHouse.getOwnerId());
		house.setProfileImage(updateHouse.getProfileImage());
		house.setCoverImage(updateHouse.getCoverImage());
		house.setDisplayMember(updateHouse.isDisplayMember());
		house.setAllowOtherView(updateHouse.isAllowOtherView());
		house.setTypeId(updateHouse.getTypeId());
		house.setStatus(updateHouse.getStatus());
		house.setWaterMeter(updateHouse.getWaterMeter());
		House updatedHouse = houseService.save(house);
		return ResponseEntity.ok(updatedHouse);
		
	}
	
	@GetMapping("/houses/count")
	public long countHouse(){
		return houseService.countHouse();
	}
	

}
