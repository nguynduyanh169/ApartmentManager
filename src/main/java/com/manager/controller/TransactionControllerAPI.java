package com.manager.controller;

import java.util.ArrayList;
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
import com.manager.dto.HouseForTransactionDTO;
import com.manager.dto.TransactionDTO;
import com.manager.entity.Transaction;
import com.manager.service.TransactionService;

import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;

@RestController
@RequestMapping("/api/v1")
@ComponentScan(basePackages = "com.manager.service")
public class TransactionControllerAPI {

	@Autowired
	TransactionService transactionService;
	
	@GetMapping("/transactions")
	@ApiImplicitParams({
		@ApiImplicitParam(name = "Authorization", value = "Authorization token", required = true, dataType = "string", paramType = "header") })
	public List<Transaction> getAllTransaction(){
		return transactionService.getAllTransaction();
	}
	@GetMapping("/transactions/houses/{houseId}")
	@ApiImplicitParams({
		@ApiImplicitParam(name = "Authorization", value = "Authorization token", required = true, dataType = "string", paramType = "header") })
	public List<TransactionDTO> getTransactionByHouseId(@PathVariable(value = "houseId") long houseId) {
		List<Transaction> transactions = transactionService.getTransactionByHouseId(houseId);
		List<TransactionDTO> transactionDTOs = new ArrayList<>();
		for (Transaction transaction : transactions) {
			TransactionDTO transactionDTO = new TransactionDTO();
			transactionDTO.setTransactionId(transaction.getTransactionId());
			transactionDTO.setTitle(transaction.getTitle());
			transactionDTO.setAmount(transaction.getAmount());
			transactionDTO.setStatus(transaction.getStatus());
			transactionDTO.setCreatedDate(transaction.getCreatedDate());
			transactionDTO.setTransactor(transaction.getTransactor());
			HouseForTransactionDTO house = new HouseForTransactionDTO(transaction.getHouse().getHouseId(),
					transaction.getHouse().getHouseName(), transaction.getHouse().getOwnerId(),
					transaction.getHouse().getCurrentMoney());
			transactionDTO.setHouse(house);
			transactionDTOs.add(transactionDTO);
		}
		return transactionDTOs;
	}

	@PostMapping("/transactions")
	@ApiImplicitParams({
		@ApiImplicitParam(name = "Authorization", value = "Authorization token", required = true, dataType = "string", paramType = "header") })
	public ResponseEntity<?> saveTransaction(@Valid @RequestBody Transaction transaction) {
		boolean flag = transactionService.saveTransaction(transaction);
		if (flag == false) {
			return new ResponseEntity<APIResponse>(new APIResponse(false, "Save failed!"), HttpStatus.BAD_REQUEST);
		} else {
			return new ResponseEntity<APIResponse>(new APIResponse(true, "Save successful!"), HttpStatus.OK);
		}
	}

}
