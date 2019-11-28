package com.manager.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Service;

import com.manager.entity.PostImage;
import com.manager.repository.PostImageRepository;

@Service
@ComponentScan(basePackages = "com.manager.repository")
public class PostImageServiceImpl implements PostImageService{

	@Autowired
	PostImageRepository postImageRepo;
	@Override
	public List<PostImage> getPostImageByPostId(long postId) {
		// TODO Auto-generated method stub
		return postImageRepo.findPostImageByPostId(postId);
	}
	@Override
	public boolean savePostImage(PostImage postImage) {
		// TODO Auto-generated method stub
		return postImageRepo.save(postImage) == null ? false : true;
	}

}
