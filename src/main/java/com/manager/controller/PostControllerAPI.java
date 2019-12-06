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

import com.manager.dto.APIResponse;
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
	
	@GetMapping("/posts/{postId}")
	public ResponseEntity<?> findPostById(@PathVariable(value = "postId") long id) throws Exception{
		Optional<Post> post = postService.findPostById(id);
		if(!post.isPresent()) {
			return new ResponseEntity<APIResponse>(new APIResponse(false, "Not found"), HttpStatus.NO_CONTENT);
		}
		return new ResponseEntity<Post>(post.get(), HttpStatus.OK);
	}
	
	@PostMapping("/posts")
	public ResponseEntity<?> savePost(@Valid @RequestBody Post post) {
		boolean flag = postService.savePost(post);
		if (flag == false) {
			return new ResponseEntity<APIResponse>(new APIResponse(false, "Save failed!"), HttpStatus.BAD_REQUEST);
		} else {
			return new ResponseEntity<APIResponse>(new APIResponse(true, "Save successful!"), HttpStatus.OK);
		}
	}
	
	@GetMapping("/posts/users/{userId}")
	public List<Post> getPostByUserId(@PathVariable(value = "userId") long userId){
		return postService.getPostByUserId(userId);
	}

}
