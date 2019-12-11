package com.manager.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Service;

import com.manager.entity.Comment;
import com.manager.repository.CommentRepository;

@Service
@ComponentScan(basePackages = "com.manager.repository")
public class CommentServiceImpl implements CommentService{

	@Autowired
	CommentRepository commentRepo;
	
	@Override
	public List<Comment> getCommentsByPostId(long id) {
		// TODO Auto-generated method stub
		return commentRepo.getCommentsByPostId(id);
	}

	@Override
	public boolean saveComment(Comment comment) {
		// TODO Auto-generated method stub
		return commentRepo.save(comment) == null ? false : true;
	}

	@Override
	public List<Comment> getAllComment() {
		// TODO Auto-generated method stub
		return commentRepo.findAll();
	}

}
