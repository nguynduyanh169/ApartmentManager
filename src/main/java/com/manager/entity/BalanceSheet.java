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
@Table(name = "BalanceSheet")
@EntityListeners(AuditingEntityListener.class)
@JsonIgnoreProperties({ "hibernateLazyInitializer", "handler" })
public class BalanceSheet implements Serializable {
	
	@OneToMany(cascade = CascadeType.ALL, mappedBy = "balanceSheet")
	@JsonIgnore
	private List<Receipt> listReceipts;
	
	@OneToMany(cascade = CascadeType.ALL, mappedBy = "balanceSheet")
	@JsonIgnore
	private List<Transaction> listTransactions;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "BalanceSheetId")
	private long balanceSheetId;

	@Column(name = "Title")
	private String title;

	@Column(name = "Description")
	private String description;

	@Column(name = "Status")
	private int status;

	@Column(name = "StartDate")
	private Date startDate;

	@Column(name = "CloseDate")
	private Date closeDate;

	@Column(name = "CreatedDate")
	@CreatedDate
	private Date createdDate;

	@Column(name = "LastModifiedDate")
	@LastModifiedDate
	private Date lastModifiedDate;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "UserId", nullable = true)
	private User user;

	@Column(name = "TotalIncome")
	private float totalIncome;

	@Column(name = "TotalExpense")
	private float totalExpense;

	@Column(name = "TotalIncomeInCash")
	private float totalIncomeInCash;

	@Column(name = "TotalExpenseInCash")
	private float totalExpenseInCash;

	@Column(name = "RedudancyStartMonth")
	private float redudancyStartMonth;

	@Column(name = "RedudancyEndMonth")
	private float redudancyEndMonth;

	public long getBalanceSheetId() {
		return balanceSheetId;
	}

	public void setBalanceSheetId(long balanceSheetId) {
		this.balanceSheetId = balanceSheetId;
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

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

	public Date getStartDate() {
		return startDate;
	}

	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}

	public Date getCloseDate() {
		return closeDate;
	}

	public void setCloseDate(Date closeDate) {
		this.closeDate = closeDate;
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

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public float getTotalIncome() {
		return totalIncome;
	}

	public void setTotalIncome(float totalIncome) {
		this.totalIncome = totalIncome;
	}

	public float getTotalExpense() {
		return totalExpense;
	}

	public void setTotalExpense(float totalExpense) {
		this.totalExpense = totalExpense;
	}

	public float getTotalIncomeInCash() {
		return totalIncomeInCash;
	}

	public void setTotalIncomeInCash(float totalIncomeInCash) {
		this.totalIncomeInCash = totalIncomeInCash;
	}

	public float getTotalExpenseInCash() {
		return totalExpenseInCash;
	}

	public void setTotalExpenseInCash(float totalExpenseInCash) {
		this.totalExpenseInCash = totalExpenseInCash;
	}

	public float getRedudancyStartMonth() {
		return redudancyStartMonth;
	}

	public void setRedudancyStartMonth(float redudancyStartMonth) {
		this.redudancyStartMonth = redudancyStartMonth;
	}

	public float getRedudancyEndMonth() {
		return redudancyEndMonth;
	}

	public void setRedudancyEndMonth(float redudancyEndMonth) {
		this.redudancyEndMonth = redudancyEndMonth;
	}

}
