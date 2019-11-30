package com.manager.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import com.manager.entity.House;

@Repository
public interface HouseRepository extends JpaRepository<House, Long>{
	
	@Query("SELECT new House(h.id, h.profileImage, h.description) from House h Where h.description is not null")
	List<House> getAllHouseLiteABC();
	
	@Query("SELECT h.profileImage from House h Where h.id = ?1")
	String getHouseImage(long id);
	
	@Query("SELECT h from House h where h.block.blockId = :blockId")
	List<House> getHouseByBlockId(@Param(value = "blockId") long blockId);
	
	@Query("SELECT h from House h where h.type.typeId = :typeId")
	List<House> getHouseByTypeId(@Param(value = "typeId") long typeId);
	
	
	
	
}
