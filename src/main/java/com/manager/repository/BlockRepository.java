package com.manager.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.manager.entity.Block;

@Repository
public interface BlockRepository extends JpaRepository<Block, Long>{

}
