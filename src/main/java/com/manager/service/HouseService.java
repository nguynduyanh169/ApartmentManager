package com.manager.service;

import java.util.List;
import java.util.Optional;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Service;

import com.manager.entity.House;
import com.manager.entity.HouseLite;
@Service
@ComponentScan(basePackages = "com.manager.repository")
public interface HouseService {
	
	public List<House> getAllHouse();
	public List<House> getHouseLite();
	public Optional<House> getHouseById(long id);
	public House save(House house);
	public long countHouse();
	public void removeHouse(long id);

}
