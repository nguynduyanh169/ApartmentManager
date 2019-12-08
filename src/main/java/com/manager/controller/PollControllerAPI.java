package com.manager.controller;

import java.util.ArrayList;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.manager.dto.APIResponse;
import com.manager.dto.PollDTO;
import com.manager.dto.UserForPollDTO;
import com.manager.entity.Poll;
import com.manager.service.PollService;

@RestController
@RequestMapping("/api/v1")
@ComponentScan(basePackages = "com.manager.service")
public class PollControllerAPI {
	
	@Autowired
	PollService pollService;
	
	@GetMapping("/polls")
	public List<PollDTO> getAllPoll(){
		List<Poll> polls = pollService.getAllPoll();
		List<PollDTO> pollDTOs = new ArrayList<>();
		for (Poll poll : polls) {
			PollDTO pollDTO = new PollDTO();
			pollDTO.setPollId(poll.getPollId());
			pollDTO.setEndDate(poll.getEndDate());
			pollDTO.setQuestion(poll.getQuestion());
			pollDTO.setAnswer1(poll.getAnswer1());
			pollDTO.setAnswer2(poll.getAnswer2());
			pollDTO.setAnswer3(poll.getAnswer3());
			pollDTO.setAnswer4(poll.getAnswer4());
			pollDTO.setAnswer5(poll.getAnswer5());
			UserForPollDTO user = new UserForPollDTO(poll.getUser().getUserId(), poll.getUser().getProfileImage(), poll.getUser().getFirstName(), poll.getUser().getLastName());
			pollDTO.setUser(user);
			pollDTOs.add(pollDTO);
		}
		return pollDTOs;
		
	}
	
	@PostMapping("/polls")
	public ResponseEntity<?> savePoll(@Valid @RequestBody Poll poll){
		boolean flag = pollService.savePoll(poll);
		if (flag == false) {
			return new ResponseEntity<APIResponse>(new APIResponse(false, "Save failed!"), HttpStatus.BAD_REQUEST);
		} else {
			return new ResponseEntity<APIResponse>(new APIResponse(true, "Save successful!"), HttpStatus.OK);
		}
	}

}
