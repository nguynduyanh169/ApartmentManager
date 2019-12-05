package com.manager.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.manager.entity.Receipt;
import com.manager.service.ReceiptService;

@RestController
@RequestMapping("/api/v1")
@ComponentScan(basePackages = "com.manager.service")
public class ReceiptControllerAPI {
	
	@Autowired
	ReceiptService receiptService;
	
	@GetMapping("/receipts/houses/{houseId}")
	public List<Receipt> getReceiptByHouseId(@PathVariable(value = "houseId") long houseId){
		return receiptService.getReceiptByHouseId(houseId);
	}

}
