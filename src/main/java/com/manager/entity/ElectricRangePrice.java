package com.manager.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name = "ElectricRangePrice")
@EntityListeners(AuditingEntityListener.class)
@JsonIgnoreProperties({ "hibernateLazyInitializer", "handler" })
public class ElectricRangePrice implements Serializable {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ElectricId")
	private long electricId;

	@Column(name = "companyName")
	private String companyName;

	@Column(name = "From0To50")
	private long from0To50;

	@Column(name = "From51To100")
	private long from51To100;

	@Column(name = "From101To200")
	private long from101To200;

	@Column(name = "From201To300")
	private long from201To300;

	@Column(name = "From301To400")
	private long from301To400;

	@Column(name = "MoreThan400")
	private long moreThan400;

	@Column(name = "VAT")
	private long vat;

	public long getElectricId() {
		return electricId;
	}

	public void setElectricId(long electricId) {
		this.electricId = electricId;
	}

	public String getCompanyName() {
		return companyName;
	}

	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}

	public long getFrom0To50() {
		return from0To50;
	}

	public void setFrom0To50(long from0To50) {
		this.from0To50 = from0To50;
	}

	public long getFrom51To100() {
		return from51To100;
	}

	public void setFrom51To100(long from51To100) {
		this.from51To100 = from51To100;
	}

	public long getFrom101To200() {
		return from101To200;
	}

	public void setFrom101To200(long from101To200) {
		this.from101To200 = from101To200;
	}

	public long getFrom201To300() {
		return from201To300;
	}

	public void setFrom201To300(long from201To300) {
		this.from201To300 = from201To300;
	}

	public long getFrom301To400() {
		return from301To400;
	}

	public void setFrom301To400(long from301To400) {
		this.from301To400 = from301To400;
	}

	public long getMoreThan400() {
		return moreThan400;
	}

	public void setMoreThan400(long moreThan400) {
		this.moreThan400 = moreThan400;
	}

	public long getVat() {
		return vat;
	}

	public void setVat(long vat) {
		this.vat = vat;
	}

}
