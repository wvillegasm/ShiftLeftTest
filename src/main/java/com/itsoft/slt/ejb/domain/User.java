package com.itsoft.slt.ejb.domain;

import java.io.Serializable;

public class User implements Serializable{

	private static final long serialVersionUID = 4626814751411625845L;

	private Long userId;

	private String userName;

	private String name;

	private String lastName;

	public User() {
		super();
	}

	public User(String userName, String name, String lastName) {
		super();
		this.userName = userName;
		this.name = name;
		this.lastName = lastName;
	}

	public Long getUserId() {
		return userId;
	}

	public void setUserId(Long userId) {
		this.userId = userId;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	@Override
	public String toString() {
		return "User [userId=" + userId + ", userName=" + userName + ", name="
				+ name + ", lastName=" + lastName + "]";
	}

}
