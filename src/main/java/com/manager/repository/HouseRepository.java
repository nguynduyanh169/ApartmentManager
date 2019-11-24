package com.manager.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.manager.entity.House;

@Repository
public interface HouseRepository extends JpaRepository<House, Long>{

}
