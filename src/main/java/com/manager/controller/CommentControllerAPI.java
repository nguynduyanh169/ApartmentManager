package com.manager.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.manager.dto.APIResponse;
import com.manager.entity.Comment;
import com.manager.service.CommentService;

@RestController
@RequestMapping("/api/v1")
@ComponentScan(basePackages = "com.manager.service")
public class CommentControllerAPI{
	
	@Autowired
	CommentService commentService;
	
	@GetMapping("/comments/posts/{postId}")
	public List<Comment> getCommentsByPostId(@PathVariable(name = "postId") long postId){
		return commentService.getCommentsByPostId(postId);
	}
	
	@PostMapping("/comments")
	public ResponseEntity<?> saveComment(@Valid @RequestBody Comment comment) {
		boolean flag = commentService.saveComment(comment);
		if (flag == false) {
			return new ResponseEntity<APIResponse>(new APIResponse(false, "Save failed!"), HttpStatus.BAD_REQUEST);
		} else {
			return new ResponseEntity<APIResponse>(new APIResponse(true, "Save successful!"), HttpStatus.OK);
		}
		
	}

}
