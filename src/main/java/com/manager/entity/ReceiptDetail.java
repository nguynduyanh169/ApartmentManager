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
@Table(name = "ReceiptDetail")
@EntityListeners(AuditingEntityListener.class)
@JsonIgnoreProperties({ "hibernateLazyInitializer", "handler" })
public class ReceiptDetail implements Serializable {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ReceiptDetailId")
	private long receiptDetailId;

	@Column(name = "Total")
	private long total;

	@Column(name = "UnitPrice")
	private long unitPrice;

	@Column(name = "Quantity")
	private int quantity;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "UtilityServiceId", nullable = true)
	private UtilityService service;

	@Column(name = "FromNumber")
	private int fromNumber;

	@Column(name = "ToNumber")
	private int toNumber;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "ReceiptId", nullable = true)
	private Receipt receipt;

	@Column(name = "CreatedDate")
	@CreatedDate
	private Date createdDate;

	@Column(name = "LastModifiedDate")
	@LastModifiedDate
	private Date lastModifiedDate;

	public long getReceiptDetailId() {
		return receiptDetailId;
	}

	public void setReceiptDetailId(long receiptDetailId) {
		this.receiptDetailId = receiptDetailId;
	}

	public long getTotal() {
		return total;
	}

	public void setTotal(long total) {
		this.total = total;
	}

	public long getUnitPrice() {
		return unitPrice;
	}

	public void setUnitPrice(long unitPrice) {
		this.unitPrice = unitPrice;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public UtilityService getService() {
		return service;
	}

	public void setService(UtilityService service) {
		this.service = service;
	}

	public int getFromNumber() {
		return fromNumber;
	}

	public void setFromNumber(int fromNumber) {
		this.fromNumber = fromNumber;
	}

	public int getToNumber() {
		return toNumber;
	}

	public void setToNumber(int toNumber) {
		this.toNumber = toNumber;
	}

	public Receipt getReceipt() {
		return receipt;
	}

	public void setReceipt(Receipt receipt) {
		this.receipt = receipt;
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
