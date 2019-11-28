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

import com.manager.entity.PostImage;
import com.manager.service.PostImageService;

@RestController
@RequestMapping("/api/v1")
@ComponentScan(basePackages = "com.manager.service")
public class PostImageControllerAPI {
	
	@Autowired
	PostImageService postImageService;
	
	@GetMapping("/postImages/posts/{id}")
	public List<PostImage> getPostImageByPostId(@PathVariable(value = "id") long postId){
		List<PostImage> listPostImages = postImageService.getPostImageByPostId(postId);
		return listPostImages;
	}
	
	@PostMapping("/postImages")
	public ResponseEntity<String> savePostImage(@Valid @RequestBody PostImage postImage){
		boolean flag = postImageService.savePostImage(postImage);
		if(flag = false) {
			return new ResponseEntity<String>("Save Failed!" , HttpStatus.NO_CONTENT);
		}
		return new ResponseEntity<String>("Save successful!", HttpStatus.OK);
	}

}
