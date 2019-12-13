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
@Table(name = "UtilityServiceRangePrice")
@EntityListeners(AuditingEntityListener.class)
@JsonIgnoreProperties({ "hibernateLazyInitializer", "handler" })
public class UtilityServiceRangePrice implements Serializable {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "UtilityServiceRangePriceId")
	private long utilityServiceRangePriceId;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "UtilityServiceId", nullable = true)
	private UtilityService utilityService;

	@Column(name = "Name")
	private String name;

	@Column(name = "FromAmount")
	private long fromAmount;

	@Column(name = "ToAmount")
	private long toAmount;

	@Column(name = "Price")
	private long price;

	@Column(name = "CreatedDate")
	@CreatedDate
	private Date createdDate;

	@Column(name = "LastModifiedDate")
	@LastModifiedDate
	private Date lastModifiedDate;

	public long getUtilityServiceRangePriceId() {
		return utilityServiceRangePriceId;
	}

	public void setUtilityServiceRangePriceId(long utilityServiceRangePriceId) {
		this.utilityServiceRangePriceId = utilityServiceRangePriceId;
	}

	public UtilityService getUtilityService() {
		return utilityService;
	}

	public void setUtilityService(UtilityService utilityService) {
		this.utilityService = utilityService;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public long getFromAmount() {
		return fromAmount;
	}

	public void setFromAmount(long fromAmount) {
		this.fromAmount = fromAmount;
	}

	public long getToAmount() {
		return toAmount;
	}

	public void setToAmount(long toAmount) {
		this.toAmount = toAmount;
	}

	public long getPrice() {
		return price;
	}

	public void setPrice(long price) {
		this.price = price;
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
