package com.manager.service;

import java.util.List;
import java.util.Optional;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Service;

import com.manager.entity.House;

@Service
@ComponentScan(basePackages = "com.manager.repository")
public interface HouseService {

	public List<House> getAllHouse();

	public List<House> getHouseByBlockId(long blockId);
	
	public List<House> getHouseByTypeId(long typeId);

	public List<House> getHouseLite();

	public Optional<House> getHouseById(long id);

	public boolean save(House house);

	public long countHouse();

	public void removeHouse(long id);

	public String getHouseImage(long id);

}
