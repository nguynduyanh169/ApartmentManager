package com.manager.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.manager.entity.Role;

@Repository
public interface RoleRepository extends JpaRepository<Role, Long>{

}
