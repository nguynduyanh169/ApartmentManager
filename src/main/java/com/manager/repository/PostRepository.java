package com.manager.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.manager.entity.Post;

@Repository
public interface PostRepository extends JpaRepository<Post, Long>{
	@Query("SELECT p from Post p where p.user.userId = :userId")
	List<Post> getPostByUserId(@Param(value = "userId") long userId);
}
