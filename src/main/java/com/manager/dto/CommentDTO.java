package com.manager.dto;

import java.util.Date;

public class CommentDTO {

	private long commentId;
	private UserForPostDTO user;
	private String detail;
	private Date createdDate;
	private PostForLikeDTO post;

	public PostForLikeDTO getPost() {
		return post;
	}

	public void setPost(PostForLikeDTO post) {
		this.post = post;
	}

	public long getCommentId() {
		return commentId;
	}

	public void setCommentId(long commentId) {
		this.commentId = commentId;
	}

	public UserForPostDTO getUser() {
		return user;
	}

	public void setUser(UserForPostDTO user) {
		this.user = user;
	}

	public String getDetail() {
		return detail;
	}

	public void setDetail(String detail) {
		this.detail = detail;
	}

	public Date getCreatedDate() {
		return createdDate;
	}

	public void setCreatedDate(Date createdDate) {
		this.createdDate = createdDate;
	}

}
