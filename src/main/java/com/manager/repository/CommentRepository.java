package com.manager.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.manager.entity.Comment;

@Repository
public interface CommentRepository extends JpaRepository<Comment, Long>{
	@Query("SELECT c from Comment c where c.post.postId = ?1")
	List<Comment> getCommentsByPostId(long postId);
	
	@Query("SELECT COUNT(c) from Comment c where c.post.postId = ?1")
	int countComment(long postId);
}
