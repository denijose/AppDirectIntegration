package com.denis.model;

import javax.xml.bind.annotation.XmlElement;

public class Item {
	private int quantity;
	private String unit;
	
	public Item(){}

	
	public Item(int quantity, String unit) {
		super();
		this.quantity = quantity;
		this.unit = unit;
	}

	@XmlElement
	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
    
	@XmlElement
	public String getUnit() {
		return unit;
	}

	public void setUnit(String unit) {
		this.unit = unit;
	}
	
	
}
