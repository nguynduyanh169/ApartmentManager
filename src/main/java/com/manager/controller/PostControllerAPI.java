package com.manager.controller;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.manager.dto.APIResponse;
import com.manager.dto.PostDTO;
import com.manager.dto.UserForPostDTO;
import com.manager.entity.Post;
import com.manager.service.PostService;

@RestController
@RequestMapping("api/v1")
@ComponentScan(basePackages = "com.manager.service")
public class PostControllerAPI {

	@Autowired
	PostService postService;

	@GetMapping("/posts")
	public List<PostDTO> getAllPost() {
		List<Post> posts = postService.getAllPost();
		List<PostDTO> postDTOs = new ArrayList<>();
		for (Post post : posts) {
			PostDTO postDTO = new PostDTO();
			postDTO.setPostId(post.getPostId());
			postDTO.setBody(post.getBody());
			postDTO.setCreatedDate(post.getCreateDate());
			UserForPostDTO user = new UserForPostDTO(post.getUser().getUserId(), post.getUser().getProfileImage(),
					post.getUser().getFirstName(), post.getUser().getLastName());
			postDTO.setUser(user);
			postDTOs.add(postDTO);
		}
		return postDTOs;
	}

	@GetMapping("/posts/{postId}")
	public ResponseEntity<?> findPostById(@PathVariable(value = "postId") long id) throws Exception {
		Optional<Post> opPost = postService.findPostById(id);
		if (!opPost.isPresent()) {
			return new ResponseEntity<APIResponse>(new APIResponse(false, "Not found!"), HttpStatus.NO_CONTENT);
		}
		Post post = opPost.get();
		PostDTO postDTO = new PostDTO();
		postDTO.setPostId(post.getPostId());
		postDTO.setBody(post.getBody());
		postDTO.setCreatedDate(post.getCreateDate());
		UserForPostDTO user = new UserForPostDTO(post.getUser().getUserId(), post.getUser().getProfileImage(),
				post.getUser().getFirstName(), post.getUser().getLastName());
		postDTO.setUser(user);
		return new ResponseEntity<PostDTO>(postDTO, HttpStatus.OK);
	}

	@PostMapping("/posts")
	public ResponseEntity<?> savePost(@Valid @RequestBody Post post) {
		Post returnPost = postService.savePostTest(post);
		if (returnPost == null) {
			return new ResponseEntity<APIResponse>(new APIResponse(false, "Save failed!"), HttpStatus.BAD_REQUEST);
		} else {
			PostDTO postDTO = new PostDTO();
			postDTO.setPostId(returnPost.getPostId());
			postDTO.setBody(returnPost.getBody());
			postDTO.setCreatedDate(returnPost.getCreateDate());
			UserForPostDTO user = new UserForPostDTO(returnPost.getUser().getUserId(), returnPost.getUser().getProfileImage(),
					returnPost.getUser().getFirstName(), returnPost.getUser().getLastName());
			postDTO.setUser(user);
			return new ResponseEntity<PostDTO>(postDTO, HttpStatus.OK);
		}
	}

	@PutMapping("/posts/{postId}")
	public ResponseEntity<?> updatePost(@PathVariable(value = "postId") long postId,
			@Valid @RequestBody Post updatePost) throws Exception {
		Optional<Post> opPost = postService.findPostById(postId);
		if (!opPost.isPresent()) {
			return new ResponseEntity<APIResponse>(new APIResponse(false, "Not found"), HttpStatus.NO_CONTENT);
		}
		Post post = opPost.get();
		post.setBody(updatePost.getBody());
		boolean flag = postService.savePost(post);
		if (flag == false) {
			return new ResponseEntity<APIResponse>(new APIResponse(false, "Save failed!"), HttpStatus.BAD_REQUEST);
		} else {
			return new ResponseEntity<APIResponse>(new APIResponse(true, "Save successful!"), HttpStatus.OK);
		}

	}

	@GetMapping("/posts/users/{userId}")
	public List<PostDTO> getPostByUserId(@PathVariable(value = "userId") long userId) {
		List<Post> posts = postService.getPostByUserId(userId);
		List<PostDTO> postDTOs = new ArrayList<>();
		for (Post post : posts) {
			PostDTO postDTO = new PostDTO();
			postDTO.setPostId(post.getPostId());
			postDTO.setBody(post.getBody());
			postDTO.setCreatedDate(post.getCreateDate());
			UserForPostDTO user = new UserForPostDTO(post.getUser().getUserId(), post.getUser().getProfileImage(),
					post.getUser().getFirstName(), post.getUser().getLastName());
			postDTO.setUser(user);
			postDTOs.add(postDTO);
		}
		return postDTOs;
	}

	@DeleteMapping("/posts/{postId}")
	public ResponseEntity<?> disablePost(@PathVariable(value = "postId") long postId) {
		postService.disablePost(postId);
		return new ResponseEntity<APIResponse>(new APIResponse(true, "Disable successful!"), HttpStatus.OK);
	}

}
