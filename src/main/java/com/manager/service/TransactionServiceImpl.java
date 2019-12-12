package com.manager.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Service;

import com.manager.entity.Transaction;
import com.manager.repository.TransactionRepository;

@Service
@ComponentScan(basePackages = "com.manager.repository")
public class TransactionServiceImpl implements TransactionService{

	@Autowired
	TransactionRepository transactionRepo;
	
	@Override
	public List<Transaction> getTransactionByHouseId(long houseId) {
		return transactionRepo.getTransactionByHouseId(houseId);
	}

	@Override
	public boolean saveTransaction(Transaction transaction) {
		return transactionRepo.save(transaction) == null ? false : true;
	}

	@Override
	public List<Transaction> getAllTransaction() {
		// TODO Auto-generated method stub
		return transactionRepo.findAll();
	}

}
