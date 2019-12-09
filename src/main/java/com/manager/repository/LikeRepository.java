package com.manager.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.manager.entity.Like;

@Repository
public interface LikeRepository extends JpaRepository<Like, Long>{
	
	@Query("SELECT l from Like l where l.post.postId = :postId")
	List<Like> getLikesByPostId(@Param(value = "postId") long postId);

}
