package com.manager.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Service;

import com.manager.entity.ElectricRangePrice;
import com.manager.repository.ElectricRangePriceRepository;

@Service
@ComponentScan(basePackages = "com.manager.repository")
public class ElectricRangePriceServiceImpl implements ElectricRangePriceService{
	@Autowired
	ElectricRangePriceRepository rangePriceRepo;
	
	@Override
	public List<ElectricRangePrice> getAllElectricRangePrice() {
		return rangePriceRepo.findAll();
	}

}
