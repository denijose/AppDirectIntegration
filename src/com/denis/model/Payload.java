package com.denis.model;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class Payload {
   private Company company;
   private Order order;
   private Account account;
   private User user;
   
   public Payload(){}
   
   public Payload(Company company, Order order, Account account, User user) {
		super();
		this.company = company;
		this.order = order;
		this.account = account;
		this.user = user;
   }

   @XmlElement
   public Company getCompany() {
	return company;
   }

	public void setCompany(Company company) {
		this.company = company;
	}

	@XmlElement
	public Order getOrder() {
		return order;
	}

	public void setOrder(Order order) {
		this.order = order;
	}

	@XmlElement
	public Account getAccount() {
		return account;
	}

	public void setAccount(Account account) {
		this.account = account;
	}
   
	@XmlElement
	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}
   
}
