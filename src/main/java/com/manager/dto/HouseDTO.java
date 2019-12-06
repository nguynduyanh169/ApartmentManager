package com.manager.dto;

public class HouseDTO {
	private long houseId;
	private String houseName;
	
	

	public HouseDTO(long houseId, String houseName) {
		super();
		this.houseId = houseId;
		this.houseName = houseName;
	}

	public long getHouseId() {
		return houseId;
	}

	public void setHouseId(long houseId) {
		this.houseId = houseId;
	}

	public String getHouseName() {
		return houseName;
	}

	public void setHouseName(String houseName) {
		this.houseName = houseName;
	}

	

}
