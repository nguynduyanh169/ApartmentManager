package com.manager.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.manager.entity.AroundProvider;
import com.manager.service.AroundProviderService;

@RestController
@RequestMapping("/api/v1")
@ComponentScan(basePackages = "com.manager.service")
public class AroundProviderControllerAPI {
	
	@Autowired
	AroundProviderService aroundProviderService;
	
	@GetMapping("/AroundProviders/AroundProviderCategories/{categoryId}")
	List<AroundProvider> getAroundProviderByCategoryId(@PathVariable(value = "categoryId") long categoryId){
		return aroundProviderService.getAroundProviderByCategoryId(categoryId);
	}

}
