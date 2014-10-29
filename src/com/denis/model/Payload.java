package com.denis.model;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class Payload {
   private Company company;
   private Order order;
   private Account account;
   
   public Payload(){}
   
   public Payload(Company company, Order order, Account account){
	   super();
	   this.company = company;
	   this.order = order;
	   this.account = account;
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
   
   
}
