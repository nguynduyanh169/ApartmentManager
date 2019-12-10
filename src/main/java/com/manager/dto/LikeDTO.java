package com.manager.dto;

import java.util.Date;

public class LikeDTO {

	private long likeId;
	private UserForPostDTO user;
	private Date createdDate;

	public long getLikeId() {
		return likeId;
	}

	public void setLikeId(long likeId) {
		this.likeId = likeId;
	}

	public UserForPostDTO getUser() {
		return user;
	}

	public void setUser(UserForPostDTO user) {
		this.user = user;
	}

	public Date getCreatedDate() {
		return createdDate;
	}

	public void setCreatedDate(Date createdDate) {
		this.createdDate = createdDate;
	}

}
