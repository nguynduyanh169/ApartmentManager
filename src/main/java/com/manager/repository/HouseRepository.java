package com.manager.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.manager.entity.House;
import com.manager.entity.HouseLite;
import com.manager.entity.User;

@Repository
public interface HouseRepository extends JpaRepository<House, Long>{
	@Query("SELECT h from House h where Description is not null")
	List<House> findAllActiveHouse();
	
	@Query(value="SELECT Id, Description, ProfileImage from House Where Description is not null", nativeQuery = true)
	List<House> findAllHouseLite();
	
}
