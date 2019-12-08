package com.manager.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.manager.entity.ReceiptDetail;
import com.manager.repository.ReceiptDetailRepository;
import com.manager.service.ReceiptDetailService;

@RestController
@RequestMapping("/api/v1")
@ComponentScan(basePackages = "com.manager.service")
public class ReceiptDetailControllerAPI {
	
	@Autowired
	ReceiptDetailService receiptDetailService;
	ReceiptDetailRepository a;
	
	@GetMapping("/receiptDetails/receipts/{receiptId}")
	public List<ReceiptDetail> getReceiptDetailByReceiptId(@PathVariable(value = "receiptId") long receiptId){
		return receiptDetailService.getReceiptDetailByReceiptId(receiptId);
	}
	

}
