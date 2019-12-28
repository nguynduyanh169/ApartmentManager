package com.manager.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.manager.entity.User;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
	@Query("SELECT u from User u where u.status = 0")
	List<User> findAllActiveUser();

	@Query("SELECT u from User u where u.house.houseId = :houseId ORDER BY u.familyLevel ASC")
	List<User> getHouseByHouseId(@Param(value = "houseId") long houseId);

	@Query("SELECT u from User u where u.email = :email and u.password =:password")
	User checkLogin(@Param(value = "email") String email, @Param(value = "password") String password);

	@Query("SELECT u from User u where u.email = :email")
	User checkUserEmail(@Param(value = "email") String email);

	@Query("UPDATE User u set u.status = 1 where u.userId = :userId")
	boolean deactivateUser(@Param("userId") long userId);

	@Transactional
	@Modifying
	@Query("UPDATE User u set u.idImage = :idImage where u.email = :email")
	int setIdImageByEmail(@Param(value = "idImage") String idImage, @Param("email") String email);

	@Transactional
	@Modifying
	@Query("UPDATE User u set u.profileImage = :profileImage where u.email = :email")
	int setProfileImageByEmail(@Param(value = "profileImage") String profileImage, @Param("email") String email);

}
