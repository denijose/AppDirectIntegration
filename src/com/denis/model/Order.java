package com.denis.model;

import java.util.List;

import javax.xml.bind.annotation.XmlElement;

public class Order {
   private String editionCode;
   private List<Item> item;
   private String pricingDuration;
   
   public Order(){}
   
   public Order(String editionCode, List<Item> item, String pricingDuration) {
	super();
	this.editionCode = editionCode;
	this.item = item;
	this.pricingDuration = pricingDuration;
   }

   @XmlElement
public String getEditionCode() {
	return editionCode;
}

public void setEditionCode(String editionCode) {
	this.editionCode = editionCode;
}

@XmlElement
public List<Item> getItem() {
	return item;
}

public void setItem(List<Item> item) {
	this.item = item;
}

@XmlElement
public String getPricingDuration() {
	return pricingDuration;
}

public void setPricingDuration(String pricingDuration) {
	this.pricingDuration = pricingDuration;
}
   
   
   
}
