package com.manager.entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import com.fasterxml.jackson.annotation.JsonView;

@Entity
@Table(name = "Users")
@EntityListeners(AuditingEntityListener.class)
public class User implements Serializable{
	
	private long id;
	private String username;
	private String password;
	private int roleId;
	private int houseId;
	private int creator;
	private String profileImage;
	private Date dateOfBirth;
	private String idNumber;
	private int gender;
	private String fullName;
	private Date createDate;
	private Date lastModified;
	private int familyLevel;
	private Date idCreatedDate;
	private int status;
	private String sendPasswordTo;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "Id")
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	
	@Column(name = "Username")
	@JsonView()
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	
	@Column(name = "Password")
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	
	@Column(name = "RoleId")
	public int getRoleId() {
		return roleId;
	}
	public void setRoleId(int roleId) {
		this.roleId = roleId;
	}
	
	@Column(name = "HouseId")
	public int getHouseId() {
		return houseId;
	}
	public void setHouseId(int houseId) {
		this.houseId = houseId;
	}
	
	@Column(name = "Creator")
	public int getCreator() {
		return creator;
	}
	public void setCreator(int creator) {
		this.creator = creator;
	}
	
	@Column(name = "ProfileImage")
	public String getProfileImage() {
		return profileImage;
	}
	public void setProfileImage(String profileImage) {
		this.profileImage = profileImage;
	}
	
	@Column(name = "DateOfBirth")
	public Date getDateOfBirth() {
		return dateOfBirth;
	}
	public void setDateOfBirth(Date dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}
	@Column(name = "IDNumber")
	public String getIdNumber() {
		return idNumber;
	}
	public void setIdNumber(String idNumber) {
		this.idNumber = idNumber;
	}
	
	@Column(name = "Gender")
	public int getGender() {
		return gender;
	}
	public void setGender(int gender) {
		this.gender = gender;
	}
	
	@Column(name = "Fullname")
	public String getFullName() {
		return fullName;
	}
	public void setFullName(String fullName) {
		this.fullName = fullName;
	}
	
	@Column(name = "CreateDate")
	@CreatedDate
	public Date getCreateDate() {
		return createDate;
	}
	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}
	
	@Column(name = "LastModified")
	@LastModifiedDate
	public Date getLastModified() {
		return lastModified;
	}
	public void setLastModified(Date lastModified) {
		this.lastModified = lastModified;
	}
	
	@Column(name = "FamilyLevel")
	public int getFamilyLevel() {
		return familyLevel;
	}
	public void setFamilyLevel(int familyLevel) {
		this.familyLevel = familyLevel;
	}
	
	@Column(name = "IDCreatedDate")
	@CreatedDate
	public Date getIdCreatedDate() {
		return idCreatedDate;
	}
	public void setIdCreatedDate(Date idCreatedDate) {
		this.idCreatedDate = idCreatedDate;
	}
	
	@Column(name = "Status")
	public int getStatus() {
		return status;
	}
	public void setStatus(int status) {
		this.status = status;
	}
	
	@Column(name = "SendPasswordTo")
	public String getSendPasswordTo() {
		return sendPasswordTo;
	}
	public void setSendPasswordTo(String sendPasswordTo) {
		this.sendPasswordTo = sendPasswordTo;
	}
	
	

}
