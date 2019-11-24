package com.manager.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.manager.entity.User;

@Repository
public interface UserRepository extends JpaRepository<User, Long>{
	@Query("SELECT u from User u where u.status = 1")
	List<User> findAllActiveUser();
}
