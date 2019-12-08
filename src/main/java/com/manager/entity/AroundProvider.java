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
@Table(name = "AroundProvider")
@EntityListeners(AuditingEntityListener.class)
@JsonIgnoreProperties({ "hibernateLazyInitializer", "handler" })
public class AroundProvider implements Serializable {

	@OneToMany(cascade = CascadeType.ALL, mappedBy = "aroundProvider")
	@JsonIgnore
	private List<AroundProviderProduct> listAroundProviderProducts;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "AroundProviderId")
	private long aroundProviderId;

	@Column(name = "AroundProviderName")
	private String aroundProviderName;

	@Column(name = "Description")
	private String description;

	@Column(name = "PhoneNo")
	private String phoneNo;

	@Column(name = "Address")
	private String address;

	@Column(name = "ClickCount")
	private int clickCount;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "AroundProviderCategoryId", nullable = true)
	private AroundProviderCategory providerCategory;

	@Column(name = "ImageUrl")
	private String imageUrl;

	@Column(name = "CreatedDate")
	@CreatedDate
	private Date createdDate;

	@Column(name = "LastModifiedDate")
	@LastModifiedDate
	private Date lastModifiedDate;

	@Column(name = "Status")
	@JsonIgnore
	private int status;

	@Column(name = "Latitude")
	private String latitude;

	@Column(name = "Longtitude")
	private String longtitude;

	public long getAroundProviderId() {
		return aroundProviderId;
	}

	public void setAroundProviderId(long aroundProviderId) {
		this.aroundProviderId = aroundProviderId;
	}

	public String getAroundProviderName() {
		return aroundProviderName;
	}

	public void setAroundProviderName(String aroundProviderName) {
		this.aroundProviderName = aroundProviderName;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getPhoneNo() {
		return phoneNo;
	}

	public void setPhoneNo(String phoneNo) {
		this.phoneNo = phoneNo;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public int getClickCount() {
		return clickCount;
	}

	public void setClickCount(int clickCount) {
		this.clickCount = clickCount;
	}

	public AroundProviderCategory getProviderCategory() {
		return providerCategory;
	}

	public void setProviderCategory(AroundProviderCategory providerCategory) {
		this.providerCategory = providerCategory;
	}

	public String getImageUrl() {
		return imageUrl;
	}

	public void setImageUrl(String imageUrl) {
		this.imageUrl = imageUrl;
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

	public String getLatitude() {
		return latitude;
	}

	public void setLatitude(String latitude) {
		this.latitude = latitude;
	}

	public String getLongtitude() {
		return longtitude;
	}

	public void setLongtitude(String longtitude) {
		this.longtitude = longtitude;
	}

	public List<AroundProviderProduct> getListAroundProviderProducts() {
		return listAroundProviderProducts;
	}

	public void setListAroundProviderProducts(List<AroundProviderProduct> listAroundProviderProducts) {
		this.listAroundProviderProducts = listAroundProviderProducts;
	}
	
	

}
