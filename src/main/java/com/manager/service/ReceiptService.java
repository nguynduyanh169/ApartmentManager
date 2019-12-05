package com.manager.service;

import java.util.List;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Service;

import com.manager.entity.Receipt;

@Service
@ComponentScan(basePackages = "com.manager.repository")
public interface ReceiptService {
	
	List<Receipt> getReceiptByHouseId(long houseId);

}
