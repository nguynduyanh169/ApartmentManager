package com.manager.dto;

import java.util.Date;

public class PostImageDTO {
	private long postImageId;

	private String url;

	private Date createdDate;
	
	private PostForLikeDTO post;

	public long getPostImageId() {
		return postImageId;
	}

	public void setPostImageId(long postImageId) {
		this.postImageId = postImageId;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public Date getCreatedDate() {
		return createdDate;
	}

	public void setCreatedDate(Date createdDate) {
		this.createdDate = createdDate;
	}

	public PostForLikeDTO getPost() {
		return post;
	}

	public void setPost(PostForLikeDTO post) {
		this.post = post;
	}
	
	
	
	
}
