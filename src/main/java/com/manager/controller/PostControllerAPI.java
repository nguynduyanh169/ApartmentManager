package com.manager.controller;

import java.util.List;
import java.util.Optional;

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

import com.manager.entity.Post;
import com.manager.service.PostService;

@RestController
@RequestMapping("api/v1")
@ComponentScan(basePackages = "com.manager.service")
public class PostControllerAPI {
	
	@Autowired
	PostService postService;
	
	@GetMapping("/posts")
	public List<Post> getAllPost(){
		return postService.getAllPost();
	}
	
	@GetMapping("/posts/{id}")
	public ResponseEntity<Post> findPostById(@PathVariable(value = "id") long id) throws Exception{
		Optional<Post> post = postService.findPostById(id);
		if(!post.isPresent()) {
			return new ResponseEntity<Post>(post.get(), HttpStatus.NO_CONTENT);
		}
		
		return new ResponseEntity<Post>(post.get(), HttpStatus.OK);
	}
	
	@PostMapping("/posts")
	public Post savePost(@Valid @RequestBody Post post) {
		return postService.savePost(post);
	}
	

}
