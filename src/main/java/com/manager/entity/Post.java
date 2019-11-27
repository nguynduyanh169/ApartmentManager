package com.manager.entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.hibernate.annotations.UpdateTimestamp;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

@Entity
@Table(name = "Post")
@EntityListeners(AuditingEntityListener.class)
public class Post implements Serializable{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "Id")
	private long id;
	
	@Column(name = "Body")
	private String body;
	
	@Column(name = "CreateDate")
	private Date createDate;
	
	@Column(name = "UpdateDate")
	private Date updateDate;
	
	@Column(name = "Status")
	private int status;
	
	@OneToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "UserId", nullable = false)
	private User user;
	
	@Column(name = "EmbedCode")
	private String embedCode;
	
	@Column(name = "Disable")
	private int disable;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
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

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
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

	public int getDisable() {
		return disable;
	}

	public void setDisable(int disable) {
		this.disable = disable;
	}
	
	
}
