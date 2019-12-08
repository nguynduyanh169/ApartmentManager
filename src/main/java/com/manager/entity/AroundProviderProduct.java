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
import javax.persistence.Table;

import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name = "AroundProviderProduct")
@EntityListeners(AuditingEntityListener.class)
@JsonIgnoreProperties({ "hibernateLazyInitializer", "handler" })
public class AroundProviderProduct implements Serializable{
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "AroundProviderProductId")
	private long aroundProviderProductId;
	
	@Column(name = "AroundProviderProductName")
	private String aroundProviderProductName;
	
	@Column(name = "Price")
	private float price;
	
	@Column(name = "ImgUrl")
	private String imgUrl;
	
	@Column(name = "Description")
	private String description;
	
	@Column(name = "CreatedDate")
	@CreatedDate
	private Date createdDate;
	
	@Column(name = "LastModifiedDate")
	@LastModifiedDate
	private Date lastModifiedDate;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "AroundProviderId", nullable = true)
	private AroundProvider aroundProvider;

	public long getAroundProviderProductId() {
		return aroundProviderProductId;
	}

	public void setAroundProviderProductId(long aroundProviderProductId) {
		this.aroundProviderProductId = aroundProviderProductId;
	}

	public String getAroundProviderProductName() {
		return aroundProviderProductName;
	}

	public void setAroundProviderProductName(String aroundProviderProductName) {
		this.aroundProviderProductName = aroundProviderProductName;
	}

	public float getPrice() {
		return price;
	}

	public void setPrice(float price) {
		this.price = price;
	}

	public String getImgUrl() {
		return imgUrl;
	}

	public void setImgUrl(String imgUrl) {
		this.imgUrl = imgUrl;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
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

	public AroundProvider getAroundProvider() {
		return aroundProvider;
	}

	public void setAroundProvider(AroundProvider aroundProvider) {
		this.aroundProvider = aroundProvider;
	}
	
	
}
