package com.manager.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.manager.dto.APIResponse;
import com.manager.dto.PostForLikeDTO;
import com.manager.dto.PostImageDTO;
import com.manager.entity.PostImage;
import com.manager.service.PostImageService;

import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;

import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

@RestController
@RequestMapping("/api/v1")
@ComponentScan(basePackages = "com.manager.service")
public class PostImageControllerAPI {

    @Autowired
    PostImageService postImageService;

    @GetMapping("/postImages/posts/{postId}")
    @ApiImplicitParams({
		@ApiImplicitParam(name = "Authorization", value = "Authorization token", required = true, dataType = "string", paramType = "header") })
    public List<PostImageDTO> getPostImageByPostId(@PathVariable(value = "postId") long postId) {
        List<PostImage> listPostImages = postImageService.getPostImageByPostId(postId);
        List<PostImageDTO> imageDTOs = new ArrayList<>();
        for (PostImage postImage : listPostImages) {
        	PostImageDTO postImageDTO = new PostImageDTO();
        	postImageDTO.setPostImageId(postImage.getPostImageId());
        	postImageDTO.setUrl(postImage.getUrl());
        	postImageDTO.setCreatedDate(postImage.getCreatedDate());
        	PostForLikeDTO post = new PostForLikeDTO();
			post.setPostId(postImage.getPost().getPostId());
			post.setBody(postImage.getPost().getBody());
			post.setCreatedDate(postImage.getPost().getCreateDate());
			postImageDTO.setPost(post);
        	imageDTOs.add(postImageDTO);
		}
        return imageDTOs;
    }
    
    @GetMapping("/postImages")
    @ApiImplicitParams({
		@ApiImplicitParam(name = "Authorization", value = "Authorization token", required = true, dataType = "string", paramType = "header") })
    public List<PostImageDTO> getAllPostImage(){
    	List<PostImage> listPostImages = postImageService.getAllPostImage();
        List<PostImageDTO> imageDTOs = new ArrayList<>();
        for (PostImage postImage : listPostImages) {
        	PostImageDTO postImageDTO = new PostImageDTO();
        	postImageDTO.setPostImageId(postImage.getPostImageId());
        	postImageDTO.setUrl(postImage.getUrl());
        	postImageDTO.setCreatedDate(postImage.getCreatedDate());
        	PostForLikeDTO post = new PostForLikeDTO();
			post.setPostId(postImage.getPost().getPostId());
			post.setBody(postImage.getPost().getBody());
			post.setCreatedDate(postImage.getPost().getCreateDate());
			postImageDTO.setPost(post);
        	imageDTOs.add(postImageDTO);
		}
        return imageDTOs;
    }
    
    @PostMapping("/postImages")
    @ApiImplicitParams({
		@ApiImplicitParam(name = "Authorization", value = "Authorization token", required = true, dataType = "string", paramType = "header") })
    public ResponseEntity<?> savePostImage(@Valid @RequestBody PostImage postImage){
    	boolean flag = postImageService.savePostImage(postImage);
		if (flag == false) {
			return new ResponseEntity<APIResponse>(new APIResponse(false, "Save failed!"), HttpStatus.BAD_REQUEST);
		} else {
			return new ResponseEntity<APIResponse>(new APIResponse(true, "Save successful!"), HttpStatus.OK);
		}
    }
}
