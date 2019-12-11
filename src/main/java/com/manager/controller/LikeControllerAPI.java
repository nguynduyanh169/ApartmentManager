package com.manager.controller;

import java.util.ArrayList;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.manager.dto.APIResponse;
import com.manager.dto.LikeDTO;
import com.manager.dto.PostDTO;
import com.manager.dto.PostForLikeDTO;
import com.manager.dto.UserDTO;
import com.manager.dto.UserForPostDTO;
import com.manager.entity.Like;
import com.manager.service.LikeService;

@RestController
@RequestMapping("api/v1")
@ComponentScan(basePackages = "com.manager.service")
public class LikeControllerAPI {

	@Autowired
	LikeService likeService;

	@GetMapping("/likes/posts/{postId}")
	public List<LikeDTO> getLikeByPostId(@PathVariable(value = "postId") long postId) {
		List<Like> likes = likeService.getLikeByPostId(postId);
		List<LikeDTO> likeDTOs = new ArrayList<>();
		for (Like like : likes) {
			LikeDTO likeDTO = new LikeDTO();
			likeDTO.setLikeId(like.getLikeId());
			UserForPostDTO user = new UserForPostDTO(like.getUser().getUserId(), like.getUser().getProfileImage(),
					like.getUser().getFirstName(), like.getUser().getLastName());
			likeDTO.setUser(user);
			likeDTO.setCreatedDate(like.getCreatedDate());
			PostForLikeDTO post = new PostForLikeDTO();
			post.setPostId(like.getPost().getPostId());
			post.setBody(like.getPost().getBody());
			post.setCreatedDate(like.getPost().getCreateDate());
			likeDTO.setPost(post);
			likeDTOs.add(likeDTO);
		}
		return likeDTOs;
	}

	@PostMapping("/likes")
	public ResponseEntity<?> saveLike(@Valid @RequestBody Like like) {
		boolean flag = likeService.saveLike(like);
		if (flag == false) {
			return new ResponseEntity<APIResponse>(new APIResponse(false, "Save failed!"), HttpStatus.BAD_REQUEST);
		} else {
			return new ResponseEntity<APIResponse>(new APIResponse(true, "Save successful!"), HttpStatus.OK);
		}
	}

	@DeleteMapping("/likes/{likeId}")
	public ResponseEntity<String> unlike(@PathVariable(value = "likeId") long likeId) {
		likeService.unliked(likeId);
		return new ResponseEntity<String>("Deleted!", HttpStatus.OK);
	}
	
	@GetMapping("/likes")
	public List<LikeDTO> getAllLike(){
		List<Like> likes = likeService.getAllLike();
		List<LikeDTO> likeDTOs = new ArrayList<>();
		for (Like like : likes) {
			LikeDTO likeDTO = new LikeDTO();
			likeDTO.setLikeId(like.getLikeId());
			UserForPostDTO user = new UserForPostDTO(like.getUser().getUserId(), like.getUser().getProfileImage(),
					like.getUser().getFirstName(), like.getUser().getLastName());
			likeDTO.setUser(user);
			likeDTO.setCreatedDate(like.getCreatedDate());
			PostForLikeDTO post = new PostForLikeDTO();
			post.setPostId(like.getPost().getPostId());
			post.setBody(like.getPost().getBody());
			post.setCreatedDate(like.getPost().getCreateDate());
			likeDTO.setPost(post);
			likeDTOs.add(likeDTO);
		}
		return likeDTOs;
	}

}
