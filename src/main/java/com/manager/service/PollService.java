package com.manager.service;

import java.util.List;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Service;

import com.manager.entity.Poll;

@Service
@ComponentScan(basePackages = "com.manager.repository")
public interface PollService {
	public List<Poll> getAllPoll();
	
	public boolean savePoll(Poll poll);
}
