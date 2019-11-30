package com.manager.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Service;

import com.manager.entity.AroundProviderCategory;
import com.manager.repository.AroundProviderCategoryRepository;

@Service
@ComponentScan(basePackages = "com.manager.repository")
public class AroundProviderCategoryServiceImpl implements AroundProviderCategoryService{

	@Autowired
	AroundProviderCategoryRepository categoryRepo;
	@Override
	public List<AroundProviderCategory> getAllProviderCategory() {
		// TODO Auto-generated method stub
		return categoryRepo.findAll();
	}
	
}
