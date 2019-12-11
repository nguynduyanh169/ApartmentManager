package com.manager.service;

import java.util.List;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Service;

import com.manager.entity.Like;

@Service
@ComponentScan(basePackages = "com.manager.repository")
public interface LikeService {
	
	public List<Like> getLikeByPostId(long postId);
	
	public boolean saveLike(Like like);
	
	public void unliked(long likeId);
	
	public List<Like> getAllLike();

}
