package com.manager.entity;

import java.io.Serializable;
import java.util.Date;
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

import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name = "HouseCategory")
@EntityListeners(AuditingEntityListener.class)
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class HouseCategory implements Serializable{
	
	@OneToMany(cascade = CascadeType.ALL, mappedBy = "type")
    private List<House> houses;
	

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "TypeId")
	private long typeId;
	
	@Column(name = "Name")
	private String name;
	
	@Column(name = "CreateDate")
	@CreatedDate
	private Date createDate;
	
	@Column(name = "LastModified")
	@org.springframework.data.annotation.LastModifiedDate
	private Date LastModified;

	public long getTypeId() {
		return typeId;
	}

	public void setTypeId(long typeId) {
		this.typeId = typeId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Date getCreateDate() {
		return createDate;
	}

	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}

	public Date getLastModified() {
		return LastModified;
	}

	public void setLastModified(Date lastModified) {
		LastModified = lastModified;
	}
	
	
	

}
