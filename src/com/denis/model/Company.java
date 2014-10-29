package com.denis.model;

import javax.xml.bind.annotation.XmlElement;  

public class Company {
	private String country;	
	private String email;
	private String name;
	private String phoneNumber;
	private String uuid;
	private String website;
	
	public Company(){}
	
	public Company(String country, String email, String name,
			String phoneNumber, String uuid, String website) {
		super();
		this.country = country;
		this.email = email;
		this.name = name;
		this.phoneNumber = phoneNumber;
		this.uuid = uuid;
		this.website = website;
	}
	
	@XmlElement
	public String getCountry() {
		return country;
	}
	public void setCountry(String country) {
		this.country = country;
	}
	@XmlElement
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	@XmlElement 
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	@XmlElement 
	public String getPhoneNumber() {
		return phoneNumber;
	}
	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}
	@XmlElement
	public String getUuid() {
		return uuid;
	}
	public void setUuid(String uuid) {
		this.uuid = uuid;
	}
	@XmlElement 
	public String getWebsite() {
		return website;
	}
	public void setWebsite(String website) {
		this.website = website;
	}
	
	
	
	
}
