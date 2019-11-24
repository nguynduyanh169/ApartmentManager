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

@Entity
@Table(name = "House")
@EntityListeners(AuditingEntityListener.class)
public class House implements Serializable{
	
	private long id;
	private int blockId;
	private String floor;
	private String houseName;
	private String description;
	private float area;
	private int ownerId;
	private String profileImage;
	private String coverImage;
	private boolean displayMember;
	private boolean allowOtherView;
	private int typeId;
	private int status;
	private int waterMeter;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "Id")
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	
	@Column(name = "BlockId")
	public int getBlockId() {
		return blockId;
	}
	public void setBlockId(int blockId) {
		this.blockId = blockId;
	}
	
	@Column(name = "Floor")
	public String getFloor() {
		return floor;
	}
	public void setFloor(String floor) {
		this.floor = floor;
	}
	
	@Column(name = "HouseName")
	public String getHouseName() {
		return houseName;
	}
	public void setHouseName(String houseName) {
		this.houseName = houseName;
	}
	
	@Column(name = "Description")
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	
	@Column(name = "Area")
	public float getArea() {
		return area;
	}
	public void setArea(float area) {
		this.area = area;
	}
	
	@Column(name = "OwnerId")
	public int getOwnerId() {
		return ownerId;
	}
	public void setOwnerId(int ownerId) {
		this.ownerId = ownerId;
	}
	
	@Column(name = "ProfileImage")
	public String getProfileImage() {
		return profileImage;
	}
	public void setProfileImage(String profileImage) {
		this.profileImage = profileImage;
	}
	
	@Column(name = "CoverImage")
	public String getCoverImage() {
		return coverImage;
	}
	public void setCoverImage(String coverImage) {
		this.coverImage = coverImage;
	}
	
	@Column(name = "DisplayMember")
	public boolean isDisplayMember() {
		return displayMember;
	}
	public void setDisplayMember(boolean displayMember) {
		this.displayMember = displayMember;
	}
	
	@Column(name = "AllowOtherView")
	public boolean isAllowOtherView() {
		return allowOtherView;
	}
	public void setAllowOtherView(boolean allowOtherView) {
		this.allowOtherView = allowOtherView;
	}
	
	@Column(name = "TypeId")
	public int getTypeId() {
		return typeId;
	}
	public void setTypeId(int typeId) {
		this.typeId = typeId;
	}
	
	@Column(name = "Status")
	public int getStatus() {
		return status;
	}
	public void setStatus(int status) {
		this.status = status;
	}
	
	@Column(name = "WaterMeter")
	public int getWaterMeter() {
		return waterMeter;
	}
	public void setWaterMeter(int waterMeter) {
		this.waterMeter = waterMeter;
	}
	@Override
	public String toString() {
		return "House [id=" + id + ", blockId=" + blockId + ", floor=" + floor + ", houseName=" + houseName
				+ ", description=" + description + ", area=" + area + ", ownerId=" + ownerId + ", profileImage="
				+ profileImage + ", coverImage=" + coverImage + ", displayMember=" + displayMember + ", allowOtherView="
				+ allowOtherView + ", typeId=" + typeId + ", status=" + status + ", waterMeter=" + waterMeter + "]";
	}
	
	
	
	
	
	

}
