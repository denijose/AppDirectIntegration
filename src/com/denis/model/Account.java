package com.denis.model;

import javax.xml.bind.annotation.XmlElement;

public class Account {
	private String accountIdentifier;
	
	public Account(){}

	public Account(String accountIdentifier) {
		super();
		this.accountIdentifier = accountIdentifier;
	}
	@XmlElement
	public String getAccountIdentifier() {
		return accountIdentifier;
	}

	public void setAccountIdentifier(String accountIdentifier) {
		this.accountIdentifier = accountIdentifier;
	}
	
	
}
