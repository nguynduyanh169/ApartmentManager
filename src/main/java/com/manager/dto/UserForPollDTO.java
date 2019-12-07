package com.manager.dto;

public class UserForPollDTO {
	
	private long userId;
	private String profileImage;
	private String firstName;
	private String lastName;

	
	public UserForPollDTO(long userId, String profileImage, String firstName, String lastName) {
		super();
		this.userId = userId;
		this.profileImage = profileImage;
		this.firstName = firstName;
		this.lastName = lastName;
	}

	public long getUserId() {
		return userId;
	}

	public void setUserId(long userId) {
		this.userId = userId;
	}

	public String getProfileImage() {
		return profileImage;
	}

	public void setProfileImage(String profileImage) {
		this.profileImage = profileImage;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

}
