package com.manager.service;

import java.util.List;
import java.util.Optional;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Service;

import com.manager.entity.Post;
@Service
@ComponentScan(basePackages = "com.manager.repository")
public interface PostService {
	public List<Post> getAllPost();
	
	public List<Post> getPostByUserId(long userId);
	
	public Optional<Post> findPostById(long id);
	
	public boolean savePost(Post post);
	
	public void disablePost(long postId);
	
	public long getPostIdByBody(String body);
	
	public Post savePostTest(Post post);
}
