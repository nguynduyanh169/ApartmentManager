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
import com.fasterxml.jackson.core.sym.Name;

@Entity
@Table(name = "Receipt")
@EntityListeners(AuditingEntityListener.class)
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class Receipt implements Serializable{
	@OneToMany(cascade = CascadeType.ALL, mappedBy = "receipt")
	@JsonIgnore
    private List<ReceiptDetail> listReceiptDetails;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ReceiptId")
	private long receiptId;
	
	@Column(name = "Title")
	private String title;
	
	@Column(name = "Description")
	private String description;
	
	@Column(name = "PublishDate")
	private Date publishDate;
	
	@Column(name = "PaymentDate")
	private Date paymentDate;
	
	@Column(name = "CreatedDate")
	@CreatedDate
	private Date createdDate;
	
	@Column(name = "LastModifiedDate")
	@LastModifiedDate
	private Date lastModifiedDate;
	
	@Column(name = "Status")
	private int status;
	
	@Column(name = "isBatch")
	private int isBatch;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "BalanceSheetId", nullable = true)
	private BalanceSheet balanceSheet;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "HouseId", nullable = true)
	private House house;

	public long getReceiptId() {
		return receiptId;
	}

	public void setReceiptId(long receiptId) {
		this.receiptId = receiptId;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Date getPublishDate() {
		return publishDate;
	}

	public void setPublishDate(Date publishDate) {
		this.publishDate = publishDate;
	}

	public Date getPaymentDate() {
		return paymentDate;
	}

	public void setPaymentDate(Date paymentDate) {
		this.paymentDate = paymentDate;
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

	public int getIsBatch() {
		return isBatch;
	}

	public void setIsBatch(int isBatch) {
		this.isBatch = isBatch;
	}

	public BalanceSheet getBalanceSheet() {
		return balanceSheet;
	}

	public void setBalanceSheet(BalanceSheet balanceSheet) {
		this.balanceSheet = balanceSheet;
	}

	public House getHouse() {
		return house;
	}

	public void setHouse(House house) {
		this.house = house;
	}

	
}
