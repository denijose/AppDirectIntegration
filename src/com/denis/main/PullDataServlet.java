package com.denis.main;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.xml.bind.JAXBException;

import com.denis.model.Event;
import com.google.appengine.labs.repackaged.org.json.JSONArray;
import com.google.appengine.labs.repackaged.org.json.JSONException;
import com.google.appengine.labs.repackaged.org.json.JSONObject;

public class PullDataServlet extends HttpServlet {
	
	public void doGet(HttpServletRequest req, HttpServletResponse resp)	throws IOException, ServletException, IOException {
		resp.setContentType("text/json");
		String jsonResponse = new String();
		try {
			jsonResponse = getJSONData();
		} catch (JSONException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		req.setAttribute("jsonResponse", jsonResponse );
		RequestDispatcher requetsDispatcherObj = req.getRequestDispatcher("/subscribe.jsp"); 
		requetsDispatcherObj.forward(req, resp);
	
	}
	
	private String getJSONData() throws JSONException{
		List<Event> orders = AppDirectIntegrationServlet.orders;
		List<Event> changes = AppDirectIntegrationServlet.changes;
		List<Event> cancellations = AppDirectIntegrationServlet.cancellations;
		// top level object placeholder for holding the different subscription events
				JSONObject eventObject = new JSONObject();
				
				// add the subscription orders new and old
				JSONArray jsonArray = new JSONArray();
				for(Event e:orders){
					JSONObject json = new JSONObject();
					json.put("createdBy", e.getCreator().getFirstName() + " " + e.getCreator().getLastName());
					json.put("companyName",e.getPayload().getCompany().getName());
					json.put("companyEmail",e.getPayload().getCompany().getEmail());
					json.put("companyPhone",e.getPayload().getCompany().getPhoneNumber());
					jsonArray.put(json);
				}
				eventObject.put("orders", jsonArray);
				
				// add the subscription changes new and old
				jsonArray = new JSONArray();
				for(Event e:changes){
					JSONObject json = new JSONObject();
					json.put("createdBy", e.getCreator().getFirstName() + " " + e.getCreator().getLastName());
					json.put("changedForAccount", e.getPayload().getAccount().getAccountIdentifier());
					jsonArray.put(json);
				}
				eventObject.put("changes", jsonArray);
				
				// add the subscription cancellations new and old
				jsonArray = new JSONArray();
				for(Event e:cancellations){
					JSONObject json = new JSONObject();
					json.put("createdBy", e.getCreator().getFirstName() + " " + e.getCreator().getLastName());
					json.put("cancelledForAccount", e.getPayload().getAccount().getAccountIdentifier());
					jsonArray.put(json);
				}
				eventObject.put("cancellations", jsonArray);
				
				//System.out.println(jsonArray.toString());
				return eventObject.toString();
	}

}
