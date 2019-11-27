package com.manager.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.manager.entity.HouseCategory;

@Repository
public interface HouseCategoryRepository extends JpaRepository<HouseCategory, Long>{

}
