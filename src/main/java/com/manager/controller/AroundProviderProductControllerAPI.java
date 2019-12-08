package com.manager.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.manager.dto.AroundProviderProductListDTO;
import com.manager.entity.AroundProviderProduct;
import com.manager.service.AroundProviderProductService;

@RestController
@RequestMapping("/api/v1")
@ComponentScan(basePackages = "com.manager.service")
public class AroundProviderProductControllerAPI {
	
	@Autowired
	AroundProviderProductService aroundProviderProductService;
	
	@GetMapping("/aroundProviderProducts/aroundProviders/{providerId}")
	public List<AroundProviderProductListDTO> getAroundProviderByCategoryId(@PathVariable(value = "providerId") long providerId){
		List<AroundProviderProduct> aroundProviderProducts = aroundProviderProductService.getProviderProductByProviderId(providerId);
		List<AroundProviderProductListDTO> productListDTOs = new ArrayList<>();
		for (AroundProviderProduct aroundProviderProduct : aroundProviderProducts) {
			AroundProviderProductListDTO aroundProviderProductListDTO = new AroundProviderProductListDTO();
			aroundProviderProductListDTO.setAroundProviderProductId(aroundProviderProduct.getAroundProviderProductId());
			aroundProviderProductListDTO.setAroundProviderProductName(aroundProviderProduct.getAroundProviderProductName());
			aroundProviderProductListDTO.setPrice(aroundProviderProduct.getPrice());
			aroundProviderProductListDTO.setDescription(aroundProviderProduct.getDescription());
			aroundProviderProductListDTO.setImgUrl(aroundProviderProduct.getImgUrl());
			productListDTOs.add(aroundProviderProductListDTO);
			
		}
		return productListDTOs;
	}

}
