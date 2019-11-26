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
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "Id")
	private long id;
	
	@Column(name = "BlockId")
	private int blockId;
	
	@Column(name = "Floor")
	private String floor;
	
	@Column(name = "HouseName")
	private String houseName;
	
	@Column(name = "Description")
	private String description;
	
	@Column(name = "Area")
	private float area;
	
	@Column(name = "OwnerId")
	private int ownerId;
	
	@Column(name = "ProfileImage")
	private String profileImage;
	
	@Column(name = "CoverImage")
	private String coverImage;
	
	@Column(name = "DisplayMember")
	private boolean displayMember;
	
	@Column(name = "AllowOtherView")
	private boolean allowOtherView;
	
	@Column(name = "TypeId")
	private int typeId;
	
	@Column(name = "Status")
	private int status;
	
	@Column(name = "WaterMeter")
	private int waterMeter;
	
	public House(long id, int blockId, String floor, String houseName, String description, float area, int ownerId,
			String profileImage, String coverImage, boolean displayMember, boolean allowOtherView, int typeId,
			int status, int waterMeter) {
		super();
		this.id = id;
		this.blockId = blockId;
		this.floor = floor;
		this.houseName = houseName;
		this.description = description;
		this.area = area;
		this.ownerId = ownerId;
		this.profileImage = profileImage;
		this.coverImage = coverImage;
		this.displayMember = displayMember;
		this.allowOtherView = allowOtherView;
		this.typeId = typeId;
		this.status = status;
		this.waterMeter = waterMeter;
	}
	
	
	
	public House() {
		super();
		// TODO Auto-generated constructor stub
	}



	public House(long id, String description, String profileImage) {
		super();
		this.id = id;
		this.description = description;
		this.profileImage = profileImage;
	}



	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	
	
	public int getBlockId() {
		return blockId;
	}
	public void setBlockId(int blockId) {
		this.blockId = blockId;
	}
	
	public String getFloor() {
		return floor;
	}
	public void setFloor(String floor) {
		this.floor = floor;
	}
	
	public String getHouseName() {
		return houseName;
	}
	public void setHouseName(String houseName) {
		this.houseName = houseName;
	}
	
	
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	
	public float getArea() {
		return area;
	}
	public void setArea(float area) {
		this.area = area;
	}
	public int getOwnerId() {
		return ownerId;
	}
	public void setOwnerId(int ownerId) {
		this.ownerId = ownerId;
	}
	public String getProfileImage() {
		return profileImage;
	}
	public void setProfileImage(String profileImage) {
		this.profileImage = profileImage;
	}
	public String getCoverImage() {
		return coverImage;
	}
	public void setCoverImage(String coverImage) {
		this.coverImage = coverImage;
	}
	public boolean isDisplayMember() {
		return displayMember;
	}
	public void setDisplayMember(boolean displayMember) {
		this.displayMember = displayMember;
	}
	public boolean isAllowOtherView() {
		return allowOtherView;
	}
	public void setAllowOtherView(boolean allowOtherView) {
		this.allowOtherView = allowOtherView;
	}
	public int getTypeId() {
		return typeId;
	}
	public void setTypeId(int typeId) {
		this.typeId = typeId;
	}
	public int getStatus() {
		return status;
	}
	public void setStatus(int status) {
		this.status = status;
	}
	public int getWaterMeter() {
		return waterMeter;
	}
	public void setWaterMeter(int waterMeter) {
		this.waterMeter = waterMeter;
	}
	
	
	
	
	
	
	

}
