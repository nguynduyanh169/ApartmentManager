package com.manager.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.manager.entity.House;
import com.manager.entity.User;

@Repository
public interface HouseRepository extends JpaRepository<House, Long>{
	@Query("SELECT h from House h where h.status = 1")
	List<House> findAllActiveHouse();
}
