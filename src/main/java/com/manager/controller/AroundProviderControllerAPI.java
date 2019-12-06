package com.manager.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.manager.dto.AroundProviderDTO;
import com.manager.entity.AroundProvider;
import com.manager.service.AroundProviderService;

@RestController
@RequestMapping("/api/v1")
@ComponentScan(basePackages = "com.manager.service")
public class AroundProviderControllerAPI {
	
	@Autowired
	AroundProviderService aroundProviderService;
	
	@GetMapping("/AroundProviders/AroundProviderCategories/{categoryId}")
	List<AroundProviderDTO> getAroundProviderByCategoryId(@PathVariable(value = "categoryId") long categoryId){
		List<AroundProvider> aroundProviders = aroundProviderService.getAroundProviderByCategoryId(categoryId);
		
		List<AroundProviderDTO> aroundProviderDTOs = new ArrayList<>();
		
		for (int i = 0; i < aroundProviders.size(); i++) {
			AroundProviderDTO providerDTO = new AroundProviderDTO();
			providerDTO.setAroundProviderId(aroundProviders.get(i).getAroundProviderId());
			providerDTO.setAroundProviderName(aroundProviders.get(i).getAroundProviderName());
			providerDTO.setDescription(aroundProviders.get(i).getDescription());
			providerDTO.setPhoneNo(aroundProviders.get(i).getPhoneNo());
			providerDTO.setAddress(aroundProviders.get(i).getAddress());
			providerDTO.setClickCount(aroundProviders.get(i).getClickCount());
			providerDTO.setImageUrl(aroundProviders.get(i).getImageUrl());
			providerDTO.setLatitude(aroundProviders.get(i).getLatitude());
			providerDTO.setLongtitude(aroundProviders.get(i).getLongtitude());
			aroundProviderDTOs.add(providerDTO);
			
		}
		return aroundProviderDTOs;
	}

}
