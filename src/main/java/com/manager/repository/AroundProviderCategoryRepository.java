package com.manager.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.manager.entity.AroundProviderCategory;

@Repository
public interface AroundProviderCategoryRepository extends JpaRepository<AroundProviderCategory, Long>{


}
