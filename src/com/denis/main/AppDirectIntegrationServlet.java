package com.denis.main;

import java.io.IOException;
import javax.servlet.http.*;

@SuppressWarnings("serial")
public class AppDirectIntegrationServlet extends HttpServlet {
	
	String[] names = new String[100];
	int i;
	
	public void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws IOException {
		resp.setContentType("text/plain");
		resp.getWriter().println("Hello, world");
		names[i++] = req.getParameter("email");
		
		for(String str : names)
			System.out.println(str + " ");
	}
}
