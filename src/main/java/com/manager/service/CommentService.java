package com.manager.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Service;

import com.manager.entity.Comment;

@Service
@ComponentScan(basePackages = "com.manager.repository")
public interface CommentService {
	
	public List<Comment> getCommentsByPostId(long id);
	public Comment saveComment(Comment comment);

}
