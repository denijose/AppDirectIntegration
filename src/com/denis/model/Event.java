package com.denis.model;

import javax.xml.bind.annotation.XmlAttribute;  
import javax.xml.bind.annotation.XmlElement;  
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class Event extends AbstractEvent {
	private String type;
	private Creator creator;
	private Payload payload;
	
	public Event(){}

	public Event(String type, Creator creator, Payload payload) {
		super();
		this.type = type;
		this.creator = creator;
		this.payload = payload;
	}

	@XmlElement
	public Creator getCreator() {
		return creator;
	}

	public void setCreator(Creator creator) {
		this.creator = creator;
	}

	@XmlElement
	public Payload getPayload() {
		return payload;
	}

	public void setPayload(Payload payload) {
		this.payload = payload;
	}

	@XmlElement
	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}
	
	
	
	


}
