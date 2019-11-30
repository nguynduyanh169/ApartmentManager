package com.manager.service;

import java.util.List;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Service;

import com.manager.entity.AroundProviderProduct;

@Service
@ComponentScan(basePackages = "com.manager.repository")
public interface AroundProviderProductService {
	public List<AroundProviderProduct> getProviderProductByProviderId(long providerId);
}
