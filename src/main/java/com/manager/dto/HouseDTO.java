package com.manager.dto;

public class HouseDTO {
	private long houseId;
	private String houseName;
	private BlockDTO block;
	private int ownerId;
	private float currentMoney;

	public HouseDTO(long houseId, String houseName, int ownerId, float currentMoney, BlockDTO block) {
		super();
		this.houseId = houseId;
		this.houseName = houseName;
		this.ownerId = ownerId;
		this.currentMoney = currentMoney;
		this.block = block;
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

	public float getCurrentMoney() {
		return currentMoney;
	}

	public void setCurrentMoney(float currentMoney) {
		this.currentMoney = currentMoney;
	}

	public BlockDTO getBlock() {
		return block;
	}

	public void setBlock(BlockDTO block) {
		this.block = block;
	}

	
	
	

}
