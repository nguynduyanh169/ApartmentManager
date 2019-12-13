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
	private long totalIncome;

	@Column(name = "TotalExpense")
	private long totalExpense;

	@Column(name = "TotalIncomeInCash")
	private long totalIncomeInCash;

	@Column(name = "TotalExpenseInCash")
	private long totalExpenseInCash;

	@Column(name = "RedudancyStartMonth")
	private long redudancyStartMonth;

	@Column(name = "RedudancyEndMonth")
	private long redudancyEndMonth;

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

	public long getTotalIncome() {
		return totalIncome;
	}

	public void setTotalIncome(long totalIncome) {
		this.totalIncome = totalIncome;
	}

	public long getTotalExpense() {
		return totalExpense;
	}

	public void setTotalExpense(long totalExpense) {
		this.totalExpense = totalExpense;
	}

	public long getTotalIncomeInCash() {
		return totalIncomeInCash;
	}

	public void setTotalIncomeInCash(long totalIncomeInCash) {
		this.totalIncomeInCash = totalIncomeInCash;
	}

	public long getTotalExpenseInCash() {
		return totalExpenseInCash;
	}

	public void setTotalExpenseInCash(long totalExpenseInCash) {
		this.totalExpenseInCash = totalExpenseInCash;
	}

	public long getRedudancyStartMonth() {
		return redudancyStartMonth;
	}

	public void setRedudancyStartMonth(long redudancyStartMonth) {
		this.redudancyStartMonth = redudancyStartMonth;
	}

	public long getRedudancyEndMonth() {
		return redudancyEndMonth;
	}

	public void setRedudancyEndMonth(long redudancyEndMonth) {
		this.redudancyEndMonth = redudancyEndMonth;
	}

}
