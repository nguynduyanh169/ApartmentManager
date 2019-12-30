package com.manager.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.manager.entity.ElectricRangePrice;
import com.manager.service.ElectricRangePriceService;

import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;

@RestController
@RequestMapping("/api/v1")
@ComponentScan(basePackages = "com.manager.service")
public class ElectricRangePriceControllerAPI {
	
	@Autowired
	ElectricRangePriceService electricRangePriceService;
	
	@GetMapping("/electricPrices")
	@ApiImplicitParams({
		@ApiImplicitParam(name = "Authorization", value = "Authorization token", required = true, dataType = "string", paramType = "header") })
	public List<ElectricRangePrice> getAllElectricRangePrice(){
		return electricRangePriceService.getAllElectricRangePrice();
	}

}
