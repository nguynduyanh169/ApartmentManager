package com.manager.entity;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.hibernate.annotations.UpdateTimestamp;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name = "Post")
@EntityListeners(AuditingEntityListener.class)
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class Post implements Serializable{
	
	@OneToMany(cascade = CascadeType.ALL, mappedBy = "post")
	@JsonIgnore
    private List<Comment> listComments;
	
	@OneToMany(cascade = CascadeType.ALL, mappedBy = "post")
	@JsonIgnore
	private List<PostImage> listPostImage;
	
	@OneToMany(cascade = CascadeType.ALL, mappedBy = "post")
	@JsonIgnore
	private List<Like> listLikes;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "PostId")
	private long postId;
	
	@Column(name = "Body")
	private String body;
	
	@Column(name = "CreateDate")
	@CreatedDate
	private Date createDate;
	
	@Column(name = "UpdateDate")
	@LastModifiedDate
	private Date updateDate;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "UserId", nullable = true)
	private User user;
	
	@Column(name = "EmbedCode")
	private String embedCode;
	
	@Column(name = "Disable")
	@JsonIgnore
	private boolean disable;

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

	public Date getCreateDate() {
		return createDate;
	}

	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}

	public Date getUpdateDate() {
		return updateDate;
	}

	public void setUpdateDate(Date updateDate) {
		this.updateDate = updateDate;
	}

	public User getUser() {
		return user;
	}

	public void setUserId(User user) {
		this.user = user;
	}

	public String getEmbedCode() {
		return embedCode;
	}

	public void setEmbedCode(String embedCode) {
		this.embedCode = embedCode;
	}

	public boolean getDisable() {
		return disable;
	}

	public void setDisable(boolean disable) {
		this.disable = disable;
	}
	
	
}
