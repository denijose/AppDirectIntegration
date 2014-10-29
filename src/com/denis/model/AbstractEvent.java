package com.denis.model;

import javax.xml.bind.annotation.XmlElement;

public abstract class AbstractEvent {
	private String type;
	private Creator creator;
	private Payload payload;
	
	abstract Creator getCreator();
	
	abstract void setCreator(Creator creator);

	abstract Payload getPayload();

	abstract void setPayload(Payload payload);
	
	abstract String getType();

	abstract void setType(String type);
	
}
