package com.manager.dto;

public class HouseForTransactionDTO {

	private long houseId;
	private String houseName;
	private int ownerId;
	private long currentMoney;

	public HouseForTransactionDTO(long houseId, String houseName, int ownerId, long currentMoney) {
		super();
		this.houseId = houseId;
		this.houseName = houseName;
		this.ownerId = ownerId;
		this.currentMoney = currentMoney;
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

	public int getOwnerId() {
		return ownerId;
	}

	public void setOwnerId(int ownerId) {
		this.ownerId = ownerId;
	}

	public long getCurrentMoney() {
		return currentMoney;
	}

	public void setCurrentMoney(long currentMoney) {
		this.currentMoney = currentMoney;
	}

}
