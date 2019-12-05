package com.manager.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.manager.entity.ReceiptDetail;

@Repository
public interface ReceiptDetailRepository extends JpaRepository<ReceiptDetail, Long>{
	
	@Query("SELECT r from ReceiptDetail r where r.receipt.receiptId = :receiptId")
	List<ReceiptDetail> getReceiptDetailByReceiptId(@Param(value = "receiptId") long receiptId);

}
