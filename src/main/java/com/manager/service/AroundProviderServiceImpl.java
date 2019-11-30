package com.manager.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Service;

import com.manager.entity.AroundProvider;
import com.manager.repository.AroundProviderRepository;

@Service
@ComponentScan(basePackages = "com.manager.repository")
public class AroundProviderServiceImpl implements AroundProviderService{

	@Autowired
	AroundProviderRepository aroundProviderRepo;
	
	@Override
	public List<AroundProvider> getAroundProviderByCategoryId(Long categoryId) {
		// TODO Auto-generated method stub
		return aroundProviderRepo.getAroundProviderByCategoryId(categoryId);
	}

}
