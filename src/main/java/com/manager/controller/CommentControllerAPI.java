package com.manager.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.manager.entity.Comment;
import com.manager.service.CommentService;

@RestController
@RequestMapping("/api/v1")
@ComponentScan(basePackages = "com.manager.service")
public class CommentControllerAPI{
	
	@Autowired
	CommentService commentService;
	
	@GetMapping("/comments/posts/{id}")
	public List<Comment> getCommentsByPostId(@PathVariable(name = "id") long postId){
		return commentService.getCommentsByPostId(postId);
	}
	
	@PostMapping("/comments")
	public Comment saveComment(@Valid @RequestBody Comment comment) {
		return commentService.saveComment(comment);
	}

}
