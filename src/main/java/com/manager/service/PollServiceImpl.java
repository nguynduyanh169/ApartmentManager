package com.manager.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Service;

import com.manager.entity.Poll;
import com.manager.repository.PollRepository;

@Service
@ComponentScan(basePackages = "com.manager.repository")
public class PollServiceImpl implements PollService {

	@Autowired
	PollRepository pollRepo;

	@Override
	public List<Poll> getAllPoll() {
		return pollRepo.findAll();
	}

	@Override
	public boolean savePoll(Poll poll) {
		return pollRepo.save(poll) == null ? false : true;
	}

}
