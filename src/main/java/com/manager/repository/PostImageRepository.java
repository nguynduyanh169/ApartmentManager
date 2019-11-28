package com.manager.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.manager.entity.PostImage;

@Repository
public interface PostImageRepository extends JpaRepository<PostImage, Long>{
	@Query("SELECT p from PostImage p where p.post.postId = :postId")
	List<PostImage> findPostImageByPostId(@Param(value = "postId") long postId);

}
