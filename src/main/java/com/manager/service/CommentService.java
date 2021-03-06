package com.manager.service;

import java.util.List;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Service;

import com.manager.entity.Comment;

@Service
@ComponentScan(basePackages = "com.manager.repository")
public interface CommentService {

	public List<Comment> getCommentsByPostId(long id);

	public boolean saveComment(Comment comment);
	
	public List<Comment> getAllComment();
	
	public int countComment(long postId);

}
