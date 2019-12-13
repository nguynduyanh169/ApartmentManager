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
@Table(name = "WaterRangePrice")
@EntityListeners(AuditingEntityListener.class)
@JsonIgnoreProperties({ "hibernateLazyInitializer", "handler" })
public class WaterRangePrice implements Serializable {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ElectricId")
	private long waterId;

	@Column(name = "CompanyName")
	private String companyName;

	@Column(name = "UpTo4m3")
	private long upTo4m3;

	@Column(name = "From4m3To6m3")
	private long from4m3To6m3;

	@Column(name = "MoreThan6m3")
	private long moreThan6m3;

	@Column(name = "VAT")
	private float vat;

	public long getWaterId() {
		return waterId;
	}

	public void setWaterId(long waterId) {
		this.waterId = waterId;
	}

	public String getCompanyName() {
		return companyName;
	}

	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}

	public long getUpTo4m3() {
		return upTo4m3;
	}

	public void setUpTo4m3(long upTo4m3) {
		this.upTo4m3 = upTo4m3;
	}

	public long getFrom4m3To6m3() {
		return from4m3To6m3;
	}

	public void setFrom4m3To6m3(long from4m3To6m3) {
		this.from4m3To6m3 = from4m3To6m3;
	}

	public long getMoreThan6m3() {
		return moreThan6m3;
	}

	public void setMoreThan6m3(long moreThan6m3) {
		this.moreThan6m3 = moreThan6m3;
	}

	public float getVat() {
		return vat;
	}

	public void setVat(float vat) {
		this.vat = vat;
	}

}
