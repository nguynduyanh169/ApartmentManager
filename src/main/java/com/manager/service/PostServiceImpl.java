package com.manager.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Service;

import com.manager.entity.Post;
import com.manager.repository.PostRepository;

@Service
@ComponentScan(basePackages = "com.manager.repository")
public class PostServiceImpl implements PostService{

	@Autowired
	PostRepository postRepo;
	@Override
	public List<Post> getAllPost() {
		// TODO Auto-generated method stub
		return postRepo.findAll();
	}

}
