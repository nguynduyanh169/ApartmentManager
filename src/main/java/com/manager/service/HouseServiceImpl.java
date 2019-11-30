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
		return listHouse;
	}

	@Override
	public Optional<House> getHouseById(long id) {
		Optional<House> house = houseRepo.findById(id);
		return house;
	}

	@Override
	public boolean save(House house) {
		return houseRepo.save(house) == null ? false : true;
	}

	@Override
	public long countHouse() {
		// TODO Auto-generated method stub
		return houseRepo.count();
	}

	@Override
	public void removeHouse(long id) {
		houseRepo.deleteById(id);
	}

	@Override
	public List<House> getHouseLite() {
		// TODO Auto-generated method stub
		List<House> listHouseLite = houseRepo.getAllHouseLiteABC();
		System.out.println(listHouseLite.size());
		return listHouseLite;
	}

	@Override
	public String getHouseImage(long id) {
		// TODO Auto-generated method stub
		return houseRepo.getHouseImage(id);
	}

	@Override
	public List<House> getHouseByBlockId(long blockId) {
		// TODO Auto-generated method stub
		return houseRepo.getHouseByBlockId(blockId);
	}

	@Override
	public List<House> getHouseByTypeId(long typeId) {
		// TODO Auto-generated method stub
		return houseRepo.getHouseByTypeId(typeId);
	}
	
	

}
