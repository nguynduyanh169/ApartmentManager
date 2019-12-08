package com.manager.dto;

public class AroundProviderProductListDTO {

	private long aroundProviderProductId;

	private String aroundProviderProductName;

	private float price;

	private String imgUrl;

	private String description;

	public long getAroundProviderProductId() {
		return aroundProviderProductId;
	}

	public void setAroundProviderProductId(long aroundProviderProductId) {
		this.aroundProviderProductId = aroundProviderProductId;
	}

	public String getAroundProviderProductName() {
		return aroundProviderProductName;
	}

	public void setAroundProviderProductName(String aroundProviderProductName) {
		this.aroundProviderProductName = aroundProviderProductName;
	}

	public float getPrice() {
		return price;
	}

	public void setPrice(float price) {
		this.price = price;
	}

	public String getImgUrl() {
		return imgUrl;
	}

	public void setImgUrl(String imgUrl) {
		this.imgUrl = imgUrl;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

}
