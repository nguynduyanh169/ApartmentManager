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
import javax.persistence.Table;

import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name = "UtilityServiceCategory")
@EntityListeners(AuditingEntityListener.class)
@JsonIgnoreProperties({ "hibernateLazyInitializer", "handler" })
public class UtilityServiceCategory implements Serializable {
	@OneToMany(cascade = CascadeType.ALL, mappedBy = "serviceCategory")
	@JsonIgnore
	private List<UtilityService> listUtilityServices;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "UtilityServiceCategoryId")
	private long utilityServiceCategoryId;

	@Column(name = "Name")
	private String name;

	@Column(name = "CreatedDate")
	@CreatedDate
	private Date createdDate;

	@Column(name = "LastModifiedDate")
	@LastModifiedDate
	private Date lastModifiedDate;
	
	@Column(name = "Status")
	private int status;

	public long getUtilityServiceCategoryId() {
		return utilityServiceCategoryId;
	}

	public void setUtilityServiceCategoryId(long utilityServiceCategoryId) {
		this.utilityServiceCategoryId = utilityServiceCategoryId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Date getCreatedDate() {
		return createdDate;
	}

	public void setCreatedDate(Date createdDate) {
		this.createdDate = createdDate;
	}

	public Date getLastModifiedDate() {
		return lastModifiedDate;
	}

	public void setLastModifiedDate(Date lastModifiedDate) {
		this.lastModifiedDate = lastModifiedDate;
	}

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

}
