package com.manager.entity;

import java.io.Serializable;
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
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.core.sym.Name;

@Entity
@Table(name = "House")
@EntityListeners(AuditingEntityListener.class)
@JsonIgnoreProperties({ "hibernateLazyInitializer", "handler" })
public class House implements Serializable {
	@OneToMany(cascade = CascadeType.ALL, mappedBy = "house")
	@JsonIgnore
	private List<User> listUser;
	
	@OneToMany(cascade = CascadeType.ALL, mappedBy = "house")
	@JsonIgnore
	private List<Receipt> lisReceipts;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "HouseId")
	private long houseId;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "BlockId", nullable = false)
	private Block block;

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

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "TypeId", nullable = false)
	private HouseCategory type;

	@Column(name = "Status")
	private int status;

	@Column(name = "WaterMeter")
	private int waterMeter;

	public House() {
		super();
		// TODO Auto-generated constructor stub
	}

	public House(long houseId, String description, String profileImage) {
		super();
		this.houseId = houseId;
		this.description = description;
		this.profileImage = profileImage;
	}


	public long getHouseId() {
		return houseId;
	}

	public void setHouseId(long houseId) {
		this.houseId = houseId;
	}

	public Block getBlock() {
		return block;
	}

	public void setBlock(Block block) {
		this.block = block;
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

	public HouseCategory getType() {
		return type;
	}

	public void setType(HouseCategory type) {
		this.type = type;
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
