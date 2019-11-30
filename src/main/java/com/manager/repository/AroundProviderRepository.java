package com.manager.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.manager.entity.AroundProvider;

@Repository
public interface AroundProviderRepository extends JpaRepository<AroundProvider, Long>{
	
	@Query("SELECT a from AroundProvider a where a.providerCategory.aroundProviderCategoryId = :aroundProviderCategoryId")
	List<AroundProvider> getAroundProviderByCategoryId(@Param(value = "aroundProviderCategoryId") long aroundProviderCategoryId);

}
