package com.manager.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.manager.entity.HouseLite;

@Repository
public interface HouseLiteRepository extends JpaRepository<HouseLite, Long>{
	@Query(value="SELECT Id, ProfileImage from House Where Description is not null", nativeQuery = true)
	List<HouseLite> findHouseLite();

}
