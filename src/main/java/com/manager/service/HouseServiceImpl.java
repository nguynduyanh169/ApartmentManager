package com.manager.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Service;

import com.manager.entity.House;
import com.manager.repository.HouseRepository;
@Service
@ComponentScan(basePackages = "com.manager.repository")
public class HouseServiceImpl implements HouseService{
	
	@Autowired
	HouseRepository houseRepo;

	@Override
	public List<House> getAllHouse() {
		List<House> listHouse = houseRepo.findAll();
		System.out.println(listHouse.size());
		return listHouse;
	}

	@Override
	public Optional<House> getHouseById(long id) {
		Optional<House> house = houseRepo.findById(id);
		return house;
	}

	@Override
	public House save(House house) {
		return houseRepo.save(house);
	}

	@Override
	public long countHouse() {
		// TODO Auto-generated method stub
		return houseRepo.count();
	}
	
	

}
