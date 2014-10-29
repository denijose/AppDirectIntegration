package com.denis.model;

import javax.xml.bind.annotation.XmlElement;

public class User {

	private String email;
	private String firstName;
	private String lastName;
	private String openID;
	
	public User(){}
	
	public User(String email, String firstName, String lastName, String openID) {
		super();
		this.email = email;
		this.firstName = firstName;
		this.lastName = lastName;
		this.openID = openID;
	}
	@XmlElement
	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
	@XmlElement
	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	@XmlElement
	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	@XmlElement
	public String getOpenID() {
		return openID;
	}

	public void setOpenID(String openID) {
		this.openID = openID;
	}

	
	
}
