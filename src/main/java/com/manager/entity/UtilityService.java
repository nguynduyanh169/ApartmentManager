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
@Table(name = "UtilityService")
@EntityListeners(AuditingEntityListener.class)
@JsonIgnoreProperties({ "hibernateLazyInitializer", "handler" })
public class UtilityService implements Serializable {
	
	@OneToMany(cascade = CascadeType.ALL, mappedBy = "service")
	@JsonIgnore
	private List<ReceiptDetail> listReceiptDetails;
	
	@OneToMany(cascade = CascadeType.ALL, mappedBy = "utilityService")
	@JsonIgnore
    private List<UtilityServiceForHouseCat> listServiceForHouseCats;
	
	@OneToMany(cascade = CascadeType.ALL, mappedBy = "utilityService")
	@JsonIgnore
    private List<UtilityServiceRangePrice> listUtilityServiceRangePrices;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "UtilityServiceId")
	private long utilityServiceId;

	@Column(name = "Name")
	private String name;

	@Column(name = "Type")
	private int type;

	@Column(name = "Status")
	private int status;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "UtilityServiceCategoryId", nullable = true)
	private UtilityServiceCategory serviceCategory;

	@Column(name = "CreatedDate")
	@CreatedDate
	private Date createdDate;

	@Column(name = "LastModifiedDate")
	@LastModifiedDate
	private Date lastModifiedDate;

	public long getUtilityServiceId() {
		return utilityServiceId;
	}

	public void setUtilityServiceId(long utilityServiceId) {
		this.utilityServiceId = utilityServiceId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getType() {
		return type;
	}

	public void setType(int type) {
		this.type = type;
	}

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

	public UtilityServiceCategory getServiceCategory() {
		return serviceCategory;
	}

	public void setServiceCategory(UtilityServiceCategory serviceCategory) {
		this.serviceCategory = serviceCategory;
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

}
