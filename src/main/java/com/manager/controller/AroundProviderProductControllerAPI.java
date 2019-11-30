package com.manager.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.manager.entity.AroundProviderProduct;
import com.manager.service.AroundProviderProductService;

@RestController
@RequestMapping("/api/v1")
@ComponentScan(basePackages = "com.manager.service")
public class AroundProviderProductControllerAPI {
	
	@Autowired
	AroundProviderProductService aroundProviderProductService;
	
	@GetMapping("/aroundProviderProducts/aroundProviders/{providerId}")
	public List<AroundProviderProduct> getAroundProviderByCategoryId(@PathVariable(value = "providerId") long providerId){
		return aroundProviderProductService.getProviderProductByProviderId(providerId);
	}

}
