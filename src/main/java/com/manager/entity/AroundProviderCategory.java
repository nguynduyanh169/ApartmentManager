package com.manager.entity;

import java.io.Serializable;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
@Entity
@Table(name = "AroundProviderCategory")
@EntityListeners(AuditingEntityListener.class)
@JsonIgnoreProperties({ "hibernateLazyInitializer", "handler" })
public class AroundProviderCategory implements Serializable {

	@OneToMany(cascade = CascadeType.ALL, mappedBy = "providerCategory")
	@JsonIgnore
	private List<AroundProvider> listAroundProviders;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "AroundProviderCategoryId")
	private long aroundProviderCategoryId;

	@Column(name = "AroundProviderCategoryName")
	private String aroundProviderCategoryName;

	@Column(name = "Status")
	@JsonIgnore
	private int status;

	public long getAroundProviderCategoryId() {
		return aroundProviderCategoryId;
	}

	public void setAroundProviderCategoryId(long aroundProviderCategoryId) {
		this.aroundProviderCategoryId = aroundProviderCategoryId;
	}

	public String getAroundProviderCategoryName() {
		return aroundProviderCategoryName;
	}

	public void setAroundProviderCategoryName(String aroundProviderCategoryName) {
		this.aroundProviderCategoryName = aroundProviderCategoryName;
	}

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}
	
	

}
