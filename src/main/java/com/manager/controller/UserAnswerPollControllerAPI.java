package com.manager.controller;

import java.util.ArrayList;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.manager.dto.APIResponse;
import com.manager.dto.UserAnswerPollDTO;
import com.manager.dto.UserForPollDTO;
import com.manager.entity.UserAnswerPoll;
import com.manager.service.UserAnswerPollService;

@RestController
@RequestMapping("/api/v1")
@ComponentScan(basePackages = "com.manager.service")
public class UserAnswerPollControllerAPI {
	
	@Autowired
	UserAnswerPollService answerPollService;
	
	@GetMapping("/userAnswerPolls/polls/{pollId}")
	public List<UserAnswerPollDTO> getUserAnswerPollByPollId(@PathVariable(value = "pollId") long pollId){
		List<UserAnswerPoll> answerPolls = answerPollService.getUserAnswerPollByPollId(pollId);
		List<UserAnswerPollDTO> answerPollDTOs = new ArrayList<>();
		for (UserAnswerPoll userAnswerPoll : answerPolls) {
			UserAnswerPollDTO answerPollDTO = new UserAnswerPollDTO();
			answerPollDTO.setUserAnswerPollId(userAnswerPoll.getUserAnswerPollId());
			answerPollDTO.setAnswer(userAnswerPoll.getAnswer());
			answerPollDTO.setAnswerDate(userAnswerPoll.getAnswerDate());
			UserForPollDTO user = new UserForPollDTO(userAnswerPoll.getUser().getUserId(), userAnswerPoll.getUser().getProfileImage(), userAnswerPoll.getUser().getFirstName(), userAnswerPoll.getUser().getLastName());
			answerPollDTO.setUser(user);
			answerPollDTOs.add(answerPollDTO);
		}
		return answerPollDTOs;
		
	}
	
	@PostMapping("/userAnswerPolls")
	public ResponseEntity<?> saveAnswer(@Valid @RequestBody UserAnswerPoll answerPoll){
		boolean flag = answerPollService.saveAnswer(answerPoll);
		if (flag == false) {
			return new ResponseEntity<APIResponse>(new APIResponse(false, "Save failed!"), HttpStatus.BAD_REQUEST);
		} else {
			return new ResponseEntity<APIResponse>(new APIResponse(true, "Save successful!"), HttpStatus.OK);
		}
	}

}
