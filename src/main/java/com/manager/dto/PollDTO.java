package com.manager.dto;

import java.util.Date;

public class PollDTO {
	private long pollId;
	private Date endDate;
	private String question;
	private String answer1;
	private String answer2;
	private String answer3;
	private String answer4;
	private String answer5;
	private UserForPollDTO user;
	public long getPollId() {
		return pollId;
	}
	public void setPollId(long pollId) {
		this.pollId = pollId;
	}
	public Date getEndDate() {
		return endDate;
	}
	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}
	public String getQuestion() {
		return question;
	}
	public void setQuestion(String question) {
		this.question = question;
	}
	public String getAnswer1() {
		return answer1;
	}
	public void setAnswer1(String answer1) {
		this.answer1 = answer1;
	}
	public String getAnswer2() {
		return answer2;
	}
	public void setAnswer2(String answer2) {
		this.answer2 = answer2;
	}
	public String getAnswer3() {
		return answer3;
	}
	public void setAnswer3(String answer3) {
		this.answer3 = answer3;
	}
	public String getAnswer4() {
		return answer4;
	}
	public void setAnswer4(String answer4) {
		this.answer4 = answer4;
	}
	public String getAnswer5() {
		return answer5;
	}
	public void setAnswer5(String answer5) {
		this.answer5 = answer5;
	}
	public UserForPollDTO getUser() {
		return user;
	}
	public void setUser(UserForPollDTO user) {
		this.user = user;
	}
	
	
	

}
