package com.manager.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Service;

import com.manager.entity.ReceiptDetail;
import com.manager.repository.ReceiptDetailRepository;

@Service
@ComponentScan(basePackages = "com.manager.repository")
public class ReceiptDetailServiceImpl implements ReceiptDetailService{
	
	@Autowired
	ReceiptDetailRepository receiptDetailRepo;

	@Override
	public List<ReceiptDetail> getReceiptDetailByReceiptId(long receiptId) {
		// TODO Auto-generated method stub
		return receiptDetailRepo.getReceiptDetailByReceiptId(receiptId);
	}

}
