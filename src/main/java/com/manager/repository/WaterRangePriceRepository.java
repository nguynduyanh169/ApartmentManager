package com.manager.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.manager.entity.WaterRangePrice;

@Repository
public interface WaterRangePriceRepository extends JpaRepository<WaterRangePrice, Long> {

}
