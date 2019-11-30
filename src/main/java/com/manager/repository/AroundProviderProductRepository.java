package com.manager.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.manager.entity.AroundProviderProduct;

@Repository
public interface AroundProviderProductRepository extends JpaRepository<AroundProviderProduct, Long> {
	
	@Query("SELECT a from AroundProviderProduct a where a.aroundProvider.aroundProviderId = :aroundProviderId")
	List<AroundProviderProduct> getProviderProductByProviderId(@Param(value = "aroundProviderId") long aroundProviderId);

}
