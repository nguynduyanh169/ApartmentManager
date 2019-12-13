package com.manager.dto;

import java.util.Date;

public class TransactionDTO {

	private long transactionId;
	private HouseForTransactionDTO house;
	private long amount;
	private String title;
	private int status;
	private long transactor;
	private Date createdDate;

	public long getTransactionId() {
		return transactionId;
	}

	public void setTransactionId(long transactionId) {
		this.transactionId = transactionId;
	}

	public HouseForTransactionDTO getHouse() {
		return house;
	}

	public void setHouse(HouseForTransactionDTO house) {
		this.house = house;
	}

	public long getAmount() {
		return amount;
	}

	public void setAmount(long amount) {
		this.amount = amount;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
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

	public long getTransactor() {
		return transactor;
	}

	public void setTransactor(long transactor) {
		this.transactor = transactor;
	}

}
