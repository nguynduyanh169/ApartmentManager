package com.manager.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.manager.entity.AroundProviderCategory;
import com.manager.service.AroundProviderCategoryService;

import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;

@RestController
@RequestMapping("/api/v1")
@ComponentScan(basePackages = "com.manager.service")
public class AroundProviderCategoryControllerAPI {
	
	@Autowired
	AroundProviderCategoryService aroundProviderCategoryService;
	
	@GetMapping("/AroundProviderCategories")
	@ApiImplicitParams({
		@ApiImplicitParam(name = "Authorization", value = "Authorization token", required = true, dataType = "string", paramType = "header") })
	public List<AroundProviderCategory> getAllProviderCategory(){
		return aroundProviderCategoryService.getAllProviderCategory();
	}

}
