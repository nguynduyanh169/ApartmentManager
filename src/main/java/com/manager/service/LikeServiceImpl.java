package com.manager.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Service;

import com.manager.entity.Like;
import com.manager.repository.LikeRepository;

@Service
@ComponentScan(basePackages = "com.manager.repository")
public class LikeServiceImpl implements LikeService{

	@Autowired
	LikeRepository likeRepo;
	
	@Override
	public List<Like> getLikeByPostId(long postId) {
		return likeRepo.getLikesByPostId(postId);
	}

	@Override
	public boolean saveLike(Like like) {
		return likeRepo.save(like) == null ? false : true;
	}

	@Override
	public void unliked(long likeId) {
		 likeRepo.deleteById(likeId);
	}

	@Override
	public List<Like> getAllLike() {
		// TODO Auto-generated method stub
		return likeRepo.findAll();
	}

}
