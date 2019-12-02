package com.manager.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Service;

import com.manager.entity.UserAnswerPoll;
import com.manager.repository.UserAnswerPollRepository;

@Service
@ComponentScan(basePackages = "com.manager.repository")
public class UserAnswerPollServiceImpl implements UserAnswerPollService{

	@Autowired
	UserAnswerPollRepository answerPollRepo;
	
	@Override
	public List<UserAnswerPoll> getUserAnswerPollByPollId(long pollId) {
		return answerPollRepo.getUserAnswerPollByPollId(pollId);
	}

	@Override
	public boolean saveAnswer(UserAnswerPoll answerPoll) {
		return answerPollRepo.save(answerPoll) == null ? false : true;
	}

}
