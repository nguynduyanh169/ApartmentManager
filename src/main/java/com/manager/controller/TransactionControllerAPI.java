package com.manager.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.manager.dto.APIResponse;
import com.manager.entity.Transaction;
import com.manager.service.TransactionService;

@RestController
@RequestMapping("/api/v1")
@ComponentScan(basePackages = "com.manager.service")
public class TransactionControllerAPI {
	
	@Autowired
	TransactionService transactionService;
	
	@GetMapping("/transactions/receiptDetails/{receiptDetailId}")
	public List<Transaction> getTransactionByReceiptDetailId(@PathVariable(value = "receiptDetailId") long receiptDetailId){
		return transactionService.getTransactionByReceiptDetailId(receiptDetailId);
	}
	
	@PostMapping("/transactions")
	public ResponseEntity<?> saveTransaction(@Valid @RequestBody Transaction transaction){
		boolean flag = transactionService.saveTransaction(transaction);
		if (flag == false) {
			return new ResponseEntity<APIResponse>(new APIResponse(false, "Save failed!"), HttpStatus.BAD_REQUEST);
		} else {
			return new ResponseEntity<APIResponse>(new APIResponse(true, "Save successful!"), HttpStatus.OK);
		}
	}

}
