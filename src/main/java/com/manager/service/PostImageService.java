package com.manager.service;

import java.util.List;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Service;

import com.manager.entity.PostImage;

@Service
@ComponentScan(basePackages = "com.manager.repository")
public interface PostImageService {
	public List<PostImage> getPostImageByPostId(long postId);
	
	public boolean savePostImage(PostImage postImage);
	
	public List<PostImage> getAllPostImage();
}
