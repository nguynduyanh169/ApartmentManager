package com.manager.service;

import java.util.List;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Service;

import com.manager.entity.Transaction;

@Service
@ComponentScan(basePackages = "com.manager.repository")
public interface TransactionService {
	
	public List<Transaction> getTransactionByHouseId(long houseId);
	
	public boolean saveTransaction(Transaction transaction);
	
	public List<Transaction> getAllTransaction();

}
