package com.manager.dto;

import java.util.Date;

public class PostDTO {

	private long postId;
	private String body;
	private Date createdDate;
	private UserForPostDTO user;
	
	public long getPostId() {
		return postId;
	}

	public void setPostId(long postId) {
		this.postId = postId;
	}

	public String getBody() {
		return body;
	}

	public void setBody(String body) {
		this.body = body;
	}

	public Date getCreatedDate() {
		return createdDate;
	}

	public void setCreatedDate(Date createdDate) {
		this.createdDate = createdDate;
	}

	public UserForPostDTO getUser() {
		return user;
	}

	public void setUser(UserForPostDTO user) {
		this.user = user;
	}

}
