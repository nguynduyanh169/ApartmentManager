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

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name = "Transactions")
@EntityListeners(AuditingEntityListener.class)
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class Transaction implements Serializable{
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "TransactionId")
	private long transactionId;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "BalanceSheetId", nullable = true)
	private BalanceSheet balanceSheet;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "ReceiptDetailId", nullable = true)
	private ReceiptDetail receiptDetail;
	
	@Column(name = "TotalAmount")
	private float totalAmount;
	
	@Column(name = "PaidAmount")
	private float paidAmount;
	
	@Column(name = "CreatedDate")
	@CreatedDate
	private Date createdDate;
	
	@Column(name = "LastModifiedDate")
	@LastModifiedDate
	private Date lastModifiedDate;

	public long getTransactionId() {
		return transactionId;
	}

	public void setTransactionId(long transactionId) {
		this.transactionId = transactionId;
	}

	public BalanceSheet getBalanceSheet() {
		return balanceSheet;
	}

	public void setBalanceSheet(BalanceSheet balanceSheet) {
		this.balanceSheet = balanceSheet;
	}

	public ReceiptDetail getReceiptDetail() {
		return receiptDetail;
	}

	public void setReceiptDetail(ReceiptDetail receiptDetail) {
		this.receiptDetail = receiptDetail;
	}

	public float getTotalAmount() {
		return totalAmount;
	}

	public void setTotalAmount(float totalAmount) {
		this.totalAmount = totalAmount;
	}

	public float getPaidAmount() {
		return paidAmount;
	}

	public void setPaidAmount(float paidAmount) {
		this.paidAmount = paidAmount;
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
