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
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name = "UtilityServiceForHouseCat")
@EntityListeners(AuditingEntityListener.class)
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class UtilityServiceForHouseCat implements Serializable{
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "UtilityServiceForHouseCatId")
	private long utilityServiceForHouseCatId;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "TypeId", nullable = true)
	private HouseCategory houseCategory;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "UtilityServiceId", nullable = true)
	private UtilityService utilityService;
	
	@Column(name = "status")
	private int status;
	
	@Column(name = "CreatedDate")
	@CreatedDate
	private Date createdDate;

	public long getUtilityServiceForHouseCatId() {
		return utilityServiceForHouseCatId;
	}

	public void setUtilityServiceForHouseCatId(long utilityServiceForHouseCatId) {
		this.utilityServiceForHouseCatId = utilityServiceForHouseCatId;
	}

	public HouseCategory getHouseCategory() {
		return houseCategory;
	}

	public void setHouseCategory(HouseCategory houseCategory) {
		this.houseCategory = houseCategory;
	}

	public UtilityService getUtilityService() {
		return utilityService;
	}

	public void setUtilityService(UtilityService utilityService) {
		this.utilityService = utilityService;
	}

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

	public Date getCreatedDate() {
		return createdDate;
	}

	public void setCreatedDate(Date createdDate) {
		this.createdDate = createdDate;
	}
	
	

}
