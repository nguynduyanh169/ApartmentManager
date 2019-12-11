package com.manager.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Service;

import com.manager.entity.Post;
import com.manager.repository.PostRepository;

@Service
@ComponentScan(basePackages = "com.manager.repository")
public class PostServiceImpl implements PostService {

	@Autowired
	PostRepository postRepo;

	@Override
	public List<Post> getAllPost() {

		return postRepo.getAllActivePost();
	}

	@Override
	public Optional<Post> findPostById(long id) {

		return postRepo.findById(id);
	}

	@Override
	public boolean savePost(Post post) {

		return postRepo.save(post) == null ? false : true;
	}

	@Override
	public List<Post> getPostByUserId(long userId) {

		return postRepo.getPostByUserId(userId);
	}

	@Override
	public void disablePost(long postId) {
		postRepo.disablePost(postId);

	}

	@Override
	public long getPostIdByBody(String body) {

		return postRepo.getPostIdByBody(body);
	}

	@Override
	public Post savePostTest(Post post) {
		// TODO Auto-generated method stub
		return postRepo.save(post);
	}

}
