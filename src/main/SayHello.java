package main;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.xml.ws.http.HTTPException;

public class SayHello extends HttpServlet {
	
	@Override
	public void service(HttpServletRequest request, HttpServletResponse response) throws HTTPException,IOException {
		PrintWriter writer = response.getWriter();
		
		writer.println("Hello,welcome to my web!");
		
		writer.close();
	}
}
