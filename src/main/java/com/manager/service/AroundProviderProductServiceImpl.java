package com.manager.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Service;

import com.manager.entity.AroundProviderProduct;
import com.manager.repository.AroundProviderProductRepository;

@Service
@ComponentScan(basePackages = "com.manager.repository")
public class AroundProviderProductServiceImpl implements AroundProviderProductService{

	@Autowired
	AroundProviderProductRepository providerProductRepo;
	@Override
	public List<AroundProviderProduct> getProviderProductByProviderId(long providerId) {
		// TODO Auto-generated method stub
		return providerProductRepo.getProviderProductByProviderId(providerId);
	}

}
