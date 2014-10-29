package com.denis.main;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.io.StringReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.*;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;
import javax.xml.transform.stream.StreamSource;

import oauth.signpost.OAuthConsumer;
import oauth.signpost.basic.DefaultOAuthConsumer;
import oauth.signpost.exception.OAuthCommunicationException;
import oauth.signpost.exception.OAuthExpectationFailedException;
import oauth.signpost.exception.OAuthMessageSignerException;

import com.google.appengine.labs.repackaged.org.json.JSONArray;
import com.google.appengine.labs.repackaged.org.json.JSONException;
import com.google.appengine.labs.repackaged.org.json.JSONObject;

import com.denis.model.*;

@SuppressWarnings("serial")
public class AppDirectIntegrationServlet extends HttpServlet {
	
	public static List<Event> orders = new ArrayList<Event>();
	public static List<Event> changes = new ArrayList<Event>();
	public static List<Event> cancellations = new ArrayList<Event>();
	
	
	public void doGet(HttpServletRequest req, HttpServletResponse resp)	throws IOException, ServletException, IOException {
		resp.setContentType("text/xml");
		String XMLResponse = new String();
		try {
			XMLResponse = sendGet(req.getParameter("url"));
		} catch (JAXBException | OAuthMessageSignerException | OAuthExpectationFailedException | OAuthCommunicationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		resp.getWriter().write(XMLResponse);
		
    }
	
	private String sendGet(String url) throws IOException, JAXBException, OAuthMessageSignerException, OAuthExpectationFailedException, OAuthCommunicationException {
		OAuthConsumer consumer = new DefaultOAuthConsumer("sampleproduct1-16021", "JvnBGkZTJR5PjOlf");		
		URL obj = new URL(url);
		HttpURLConnection con = (HttpURLConnection) obj.openConnection();
		consumer.sign(con);
		con.setRequestMethod("GET");
 
		int responseCode = con.getResponseCode();
		System.out.println("\nSending 'GET' request to URL : " + url);
		System.out.println("Response Code : " + responseCode);
 
		BufferedReader in = new BufferedReader(new InputStreamReader(con.getInputStream()));
		String inputLine;
		StringBuffer response = new StringBuffer();
 
		while ((inputLine = in.readLine()) != null) {
			response.append(inputLine);
		}
		System.out.println(response.toString());
		in.close();
		return readXML(response.toString()); 
	}
	
	private String readXML(String xml) throws JAXBException {
		JAXBContext jaxbContext =  JAXBContext.newInstance(Event.class);
		Unmarshaller jaxbUnmarshaller = jaxbContext.createUnmarshaller(); 
		Event event = (Event) jaxbUnmarshaller.unmarshal(new StreamSource(new StringReader(xml))); 
		//System.out.println(event.getCreator().getFirstName());
		if(event.getType().equalsIgnoreCase("SUBSCRIPTION_ORDER")){
		    orders.add(event);
		    String accountIdentifier = event.getPayload().getCompany().getUuid();
		    event.getPayload().setAccount(new Account(accountIdentifier));
		    return "<?xml version=\"1.0\" encoding=\"UTF-8\" standalone=\"yes\"?><result><success>true</success><message>Account creation successful</message><accountIdentifier>"+ accountIdentifier+"</accountIdentifier></result>";
		}    
		if(event.getType().equalsIgnoreCase("SUBSCRIPTION_CHANGE")){
		    changes.add(event);
		    String accountIdentifier = event.getPayload().getAccount().getAccountIdentifier();
		    return "<?xml version=\"1.0\" encoding=\"UTF-8\" standalone=\"yes\"?><result><success>true</success><message>Subscription change successful</message><accountIdentifier>"+ accountIdentifier +"</accountIdentifier></result>";
		}    
		if(event.getType().equalsIgnoreCase("SUBSCRIPTION_CANCEL")){
		    cancellations.add(event);
		    String accountIdentifier = event.getPayload().getAccount().getAccountIdentifier();
		    return "<?xml version=\"1.0\" encoding=\"UTF-8\" standalone=\"yes\"?><result><success>true</success><message>Subscription cancellation successful</message><accountIdentifier>"+ accountIdentifier +"</accountIdentifier></result>";
			
		}    
		
		return null;
		
		
	}
	   

    
 
}
