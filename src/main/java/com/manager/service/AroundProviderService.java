package com.manager.service;

import java.util.List;
import java.util.Optional;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Service;

import com.manager.entity.AroundProvider;

@Service
@ComponentScan(basePackages = "com.manager.repository")
public interface AroundProviderService {
	
	List<AroundProvider> getAroundProviderByCategoryId(long categoryId);
	Optional<AroundProvider> getAroundProviderById(long aroundProviderId);

}
