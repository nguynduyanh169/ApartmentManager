package com.manager.controller;

import java.util.ArrayList;
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
import com.manager.dto.CommentDTO;
import com.manager.dto.PostForLikeDTO;
import com.manager.dto.UserForPostDTO;
import com.manager.entity.Comment;
import com.manager.service.CommentService;

@RestController
@RequestMapping("/api/v1")
@ComponentScan(basePackages = "com.manager.service")
public class CommentControllerAPI {

	@Autowired
	CommentService commentService;

	@GetMapping("/comments/posts/{postId}")
	public List<CommentDTO> getCommentsByPostId(@PathVariable(name = "postId") long postId) {
		List<Comment> comments = commentService.getCommentsByPostId(postId);
		List<CommentDTO> commentDTOs = new ArrayList<>();
		for (Comment comment : comments) {
			CommentDTO commentDTO = new CommentDTO();
			commentDTO.setCommentId(comment.getCommentId());
			commentDTO.setCreatedDate(comment.getCreatedDate());
			commentDTO.setDetail(comment.getDetail());
			UserForPostDTO user = new UserForPostDTO(comment.getUser().getUserId(), comment.getUser().getProfileImage(),
					comment.getUser().getFirstName(), comment.getUser().getLastName());
			commentDTO.setUser(user);
			PostForLikeDTO post = new PostForLikeDTO();
			post.setPostId(comment.getPost().getPostId());
			post.setBody(comment.getPost().getBody());
			post.setCreatedDate(comment.getPost().getCreateDate());
			commentDTO.setPost(post);
			commentDTOs.add(commentDTO);
		}
		return commentDTOs;
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

	@GetMapping("/comments")
	public List<CommentDTO> getAllComment() {
		List<Comment> comments = commentService.getAllComment();
		List<CommentDTO> commentDTOs = new ArrayList<>();
		for (Comment comment : comments) {
			CommentDTO commentDTO = new CommentDTO();
			commentDTO.setCommentId(comment.getCommentId());
			commentDTO.setCreatedDate(comment.getCreatedDate());
			commentDTO.setDetail(comment.getDetail());
			UserForPostDTO user = new UserForPostDTO(comment.getUser().getUserId(), comment.getUser().getProfileImage(),
					comment.getUser().getFirstName(), comment.getUser().getLastName());
			commentDTO.setUser(user);
			PostForLikeDTO post = new PostForLikeDTO();
			post.setPostId(comment.getPost().getPostId());
			post.setBody(comment.getPost().getBody());
			post.setCreatedDate(comment.getPost().getCreateDate());
			commentDTO.setPost(post);
			commentDTOs.add(commentDTO);
		}
		return commentDTOs;
	}
	
	@GetMapping("/comments/count/posts/{postId}")
	public int countCommentByPostId(@PathVariable(value = "postId") long postId) {
		return commentService.countComment(postId);
	}

}
