package com.denis.test;

import java.io.File;
import java.io.StringReader;

import com.denis.model.*;

import javax.xml.bind.JAXBContext;  
import javax.xml.bind.JAXBException;  
import javax.xml.bind.Unmarshaller;  
import javax.xml.transform.stream.StreamSource;

public class Test {

	/**
	 * @param args
	 * @throws JAXBException 
	 */
	public static void main(String[] args) throws JAXBException {
		 String xml = "<company><country>CA</country><email>company-email@example.com</email><name>Example Company Name</name><phoneNumber>415-555-1212</phoneNumber><uuid>d15bb36e-5fb5-11e0-8c3c-00262d2cda03</uuid><website>http://www.example.com</website></company>";
		 readXML(new File("src/com/denis/test/event.xml"));
	}
	
	private static void readXML(File xmlFile) throws JAXBException{
		JAXBContext jaxbContext =  JAXBContext.newInstance(Event.class);
		Unmarshaller jaxbUnmarshaller = jaxbContext.createUnmarshaller(); 
		Event event = (Event) jaxbUnmarshaller.unmarshal(xmlFile); 
		System.out.println(event.getCreator().getFirstName());
	}
	
	private static void readXML(String xml) throws JAXBException{
		JAXBContext jaxbContext =  JAXBContext.newInstance(Event.class);
		Unmarshaller jaxbUnmarshaller = jaxbContext.createUnmarshaller(); 
		Event event = (Event) jaxbUnmarshaller.unmarshal(new StreamSource(new StringReader(xml))); 
		
	}

}
