package util;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.xml.ws.http.HTTPException;

public class Login extends HttpServlet {
	
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws HTTPException,IOException {
		// get the paramter
		String username = request.getParameter("username");
		String passwd = request.getParameter("passwd");
		
		// set the encoding
		response.setContentType("text/html;charset=utf-8");
		
		// return the html page
		PrintWriter writer = response.getWriter();
		writer.println("<html>");
		writer.println("<head>");
		writer.println("<title>欢迎</title>");
		writer.println("</head>");
		
		writer.println("<body>");
		writer.println("你好，[" + username + "],欢迎光临！");
		writer.println("</body>");
		
		writer.println("</html>");
	}
	
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws HTTPException,IOException {
		doGet(request, response);
	}
	
}
