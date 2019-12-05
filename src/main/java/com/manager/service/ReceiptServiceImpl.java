package com.manager.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Service;

import com.manager.entity.Receipt;
import com.manager.repository.ReceiptRepository;

@Service
@ComponentScan(basePackages = "com.manager.repository")
public class ReceiptServiceImpl implements ReceiptService{
	
	@Autowired
	ReceiptRepository receiptRepo;

	@Override
	public List<Receipt> getReceiptByHouseId(long houseId) {
		return receiptRepo.getReceiptByHouseId(houseId);
	}

}
