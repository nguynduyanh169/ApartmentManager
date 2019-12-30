package com.manager.controller;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.manager.dto.APIResponse;
import com.manager.entity.Receipt;
import com.manager.service.ReceiptService;

import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;

@RestController
@RequestMapping("/api/v1")
@ComponentScan(basePackages = "com.manager.service")
public class ReceiptControllerAPI {

	@Autowired
	ReceiptService receiptService;

	@GetMapping("/receipts/houses/{houseId}")
	@ApiImplicitParams({
		@ApiImplicitParam(name = "Authorization", value = "Authorization token", required = true, dataType = "string", paramType = "header") })
	public List<Receipt> getReceiptByHouseId(@PathVariable(value = "houseId") long houseId) {
		return receiptService.getReceiptByHouseId(houseId);
	}

	@PutMapping("/receipts/{receiptId}/status/{status}")
	@ApiImplicitParams({
		@ApiImplicitParam(name = "Authorization", value = "Authorization token", required = true, dataType = "string", paramType = "header") })
	public ResponseEntity<?> setStatusForReceiptByReceiptId(@PathVariable(value = "receiptId") long receiptId,
			@PathVariable(value = "status") int status) throws Exception {
		Optional<Receipt> opReceipt = receiptService.getReceiptById(receiptId);
		if (!opReceipt.isPresent()) {
			return new ResponseEntity<Receipt>(opReceipt.get(), HttpStatus.NO_CONTENT);
		} else {
			opReceipt.get().setStatus(status);
			opReceipt.get().setPaymentDate(new Date());
			boolean flag = receiptService.saveReceipt(opReceipt.get());
			if (flag == false) {
				return new ResponseEntity<APIResponse>(new APIResponse(false, "Save failed!"), HttpStatus.BAD_REQUEST);
			} else {
				return new ResponseEntity<APIResponse>(new APIResponse(true, "Save successful!"), HttpStatus.OK);
			}
		}
	}

}
