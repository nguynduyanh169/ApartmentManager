package com.manager.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.manager.entity.Receipt;

@Repository
public interface ReceiptRepository extends JpaRepository<Receipt, Long>{
	
	@Query("SELECT r from Receipt r where r.house.houseId = :houseId")
	List<Receipt> getReceiptByHouseId(@Param(value = "houseId") long houseId);

}
