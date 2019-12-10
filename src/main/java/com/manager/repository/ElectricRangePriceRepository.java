package com.manager.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.manager.entity.ElectricRangePrice;

@Repository
public interface ElectricRangePriceRepository extends JpaRepository<ElectricRangePrice, Long>{

}
