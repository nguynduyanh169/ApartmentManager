package com.manager.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.PathVariable;

import com.manager.entity.House;
import com.manager.entity.User;

@Repository
public interface HouseRepository extends JpaRepository<House, Long>{
	
	@Query("SELECT new House(h.id, h.profileImage, h.description) from House h Where h.description is not null")
	List<House> getAllHouseLiteABC();
	
	
	@Query("SELECT h.profileImage from House h Where h.id = ?1")
	String getHouseImage(long id);
//	House findById(Long id);
	
	
}
