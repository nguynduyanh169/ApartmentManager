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
public class ElectricRangePrice implements Serializable{

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ElectricId")
	private long electricId;

	@Column(name = "companyName")
	private String companyName;

	@Column(name = "From0To50")
	private float from0To50;

	@Column(name = "From51To100")
	private float from51To100;

	@Column(name = "From101To200")
	private float from101To200;

	@Column(name = "From201To300")
	private float from201To300;

	@Column(name = "From301To400")
	private float from301To400;

	@Column(name = "MoreThan400")
	private float moreThan400;

	@Column(name = "VAT")
	private float vat;

	
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

	public float getFrom0To50() {
		return from0To50;
	}

	public void setFrom0To50(float from0To50) {
		this.from0To50 = from0To50;
	}

	public float getFrom51To100() {
		return from51To100;
	}

	public void setFrom51To100(float from51To100) {
		this.from51To100 = from51To100;
	}

	public float getFrom101To200() {
		return from101To200;
	}

	public void setFrom101To200(float from101To200) {
		this.from101To200 = from101To200;
	}

	public float getFrom201To300() {
		return from201To300;
	}

	public void setFrom201To300(float from201To300) {
		this.from201To300 = from201To300;
	}

	public float getFrom301To400() {
		return from301To400;
	}

	public void setFrom301To400(float from301To400) {
		this.from301To400 = from301To400;
	}

	public float getMoreThan400() {
		return moreThan400;
	}

	public void setMoreThan400(float moreThan400) {
		this.moreThan400 = moreThan400;
	}

	public float getVat() {
		return vat;
	}

	public void setVat(float vat) {
		this.vat = vat;
	}

}
