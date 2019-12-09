package com.manager.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Service;

import com.manager.entity.WaterRangePrice;
import com.manager.repository.WaterRangePriceRepository;

@Service
@ComponentScan(basePackages = "com.manager.repository")
public class WaterRangePriceServiceImpl implements WaterRangePriceService{
	@Autowired
	WaterRangePriceRepository rangePriceRepo;

	@Override
	public List<WaterRangePrice> getAllWaterRangePrice() {
		// TODO Auto-generated method stub
		return rangePriceRepo.findAll();
	}

}
