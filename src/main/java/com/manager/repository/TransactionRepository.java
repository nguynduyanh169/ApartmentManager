package com.manager.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.manager.entity.Transaction;

@Repository
public interface TransactionRepository extends JpaRepository<Transaction, Long>{
	
	@Query("SELECT t from Transaction t where t.receiptDetail.receiptDetailId = :receiptDetailId")
	List<Transaction> getTransactionByReceiptDetailId(@Param(value = "receiptDetailId") long receiptDetailId);

}
