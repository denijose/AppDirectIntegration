package com.denis.model;

import javax.xml.bind.annotation.XmlElement;

public class Creator {
	private String email;
	private String firstName;
	private String language;
	private String lastName;
	private String uuid;
	private String openID;
	
	public Creator(){}
	
	public Creator(String email, String firstName, String language,	String lastName, String uuid, String openID) {
		super();
		this.email = email;
		this.firstName = firstName;
		this.language = language;
		this.lastName = lastName;
		this.uuid = uuid;
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
	public String getLanguage() {
		return language;
	}

	public void setLanguage(String language) {
		this.language = language;
	}
	@XmlElement
	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	@XmlElement
	public String getUuid() {
		return uuid;
	}

	public void setUuid(String uuid) {
		this.uuid = uuid;
	}

	public String getOpenID() {
		return openID;
	}

	public void setOpenID(String openID) {
		this.openID = openID;
	}
	
	
	
}
