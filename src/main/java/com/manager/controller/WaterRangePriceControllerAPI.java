package com.manager.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.manager.entity.WaterRangePrice;
import com.manager.service.WaterRangePriceService;

@RestController
@RequestMapping("api/v1")
@ComponentScan(basePackages = "com.manager.service")
public class WaterRangePriceControllerAPI {
	
	@Autowired
	WaterRangePriceService rangePriceService;
	
	
	@GetMapping("/waterPrices")
	public List<WaterRangePrice> getAllWaterRangePrice(){
		return rangePriceService.getAllWaterRangePrice();
	}

}
