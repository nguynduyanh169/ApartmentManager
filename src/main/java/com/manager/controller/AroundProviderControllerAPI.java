package com.manager.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.manager.dto.APIResponse;
import com.manager.dto.AroundProviderDTO;
import com.manager.dto.AroundProviderListDTO;
import com.manager.entity.AroundProvider;
import com.manager.service.AroundProviderService;

@RestController
@RequestMapping("/api/v1")
@ComponentScan(basePackages = "com.manager.service")
public class AroundProviderControllerAPI {

	@Autowired
	AroundProviderService aroundProviderService;
	
	@GetMapping("/AroundProviders")
	public List<AroundProvider> getAllAroundProvider(){
		return aroundProviderService.getAllAroundProvider();
	}

	@GetMapping("/AroundProviders/AroundProviderCategories/{categoryId}")
	public List<AroundProviderListDTO> getAroundProviderByCategoryId(
			@PathVariable(value = "categoryId") long categoryId) {
		List<AroundProvider> aroundProviders = aroundProviderService.getAroundProviderByCategoryId(categoryId);
		List<AroundProviderListDTO> aroundProviderListDTOs = new ArrayList<>();

		for (AroundProvider aroundProvider : aroundProviders) {
			AroundProviderListDTO providerDTO = new AroundProviderListDTO();
			providerDTO.setAroundProviderId(aroundProvider.getAroundProviderId());
			providerDTO.setAroundProviderName(aroundProvider.getAroundProviderName());
			providerDTO.setAddress(aroundProvider.getAddress());
			aroundProviderListDTOs.add(providerDTO);

		}
		return aroundProviderListDTOs;
	}

	@GetMapping("/AroundProviders/{aroundProviderId}")
	public ResponseEntity<?> getAroundProviderById(@PathVariable(value = "aroundProviderId") long aroundProviderId)
			throws Exception {
		Optional<AroundProvider> opAroundProvider = aroundProviderService.getAroundProviderById(aroundProviderId);
		if (!opAroundProvider.isPresent()) {
			return new ResponseEntity<APIResponse>(new APIResponse(false, "Not found!"), HttpStatus.NO_CONTENT);
		} else {
			AroundProvider aroundProvider = opAroundProvider.get();
			AroundProviderDTO providerDTO = new AroundProviderDTO();
			providerDTO.setAroundProviderId(aroundProvider.getAroundProviderId());
			providerDTO.setAroundProviderName(aroundProvider.getAroundProviderName());
			providerDTO.setDescription(aroundProvider.getDescription());
			providerDTO.setPhoneNo(aroundProvider.getPhoneNo());
			providerDTO.setAddress(aroundProvider.getAddress());
			providerDTO.setClickCount(aroundProvider.getClickCount());
			providerDTO.setImageUrl(aroundProvider.getImageUrl());
			providerDTO.setLatitude(aroundProvider.getLatitude());
			providerDTO.setLongtitude(aroundProvider.getLongtitude());
			return new ResponseEntity<AroundProviderDTO>(providerDTO, HttpStatus.OK);
		}
	}

	@PutMapping("/AroundProviders/{aroundProviderId}/clickCount")
	public ResponseEntity<?> changeClickCountById(@PathVariable(value = "aroundProviderId") long aroundProviderId)
			throws Exception {
		Optional<AroundProvider> opAroundProvider = aroundProviderService.getAroundProviderById(aroundProviderId);
		if (!opAroundProvider.isPresent()) {
			return new ResponseEntity<APIResponse>(new APIResponse(false, "Not found!"), HttpStatus.NO_CONTENT);
		} else {
			AroundProvider aroundProvider = opAroundProvider.get();
			aroundProvider.setClickCount(aroundProvider.getClickCount() + 1);
			boolean flag = aroundProviderService.saveAroundProvider(aroundProvider);
			if (flag == false) {
				return new ResponseEntity<APIResponse>(new APIResponse(false, "Save failed!"), HttpStatus.BAD_REQUEST);
			} else {
				return new ResponseEntity<APIResponse>(new APIResponse(true, "Save successful!"), HttpStatus.OK);
			}
		}
	}

}
