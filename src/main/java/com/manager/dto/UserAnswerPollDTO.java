package com.manager.dto;

import java.util.Date;

public class UserAnswerPollDTO {

	private long userAnswerPollId;
	private String answer;
	private Date answerDate;
	private UserForPollDTO user;

	public long getUserAnswerPollId() {
		return userAnswerPollId;
	}

	public void setUserAnswerPollId(long userAnswerPollId) {
		this.userAnswerPollId = userAnswerPollId;
	}

	public String getAnswer() {
		return answer;
	}

	public void setAnswer(String answer) {
		this.answer = answer;
	}

	public Date getAnswerDate() {
		return answerDate;
	}

	public void setAnswerDate(Date answerDate) {
		this.answerDate = answerDate;
	}

	public UserForPollDTO getUser() {
		return user;
	}

	public void setUser(UserForPollDTO user) {
		this.user = user;
	}

}
