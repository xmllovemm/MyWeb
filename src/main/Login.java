package main;

import java.beans.Statement;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.CallableStatement;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.xml.ws.http.HTTPException;

import com.sun.corba.se.pept.transport.Connection;
import com.sun.corba.se.spi.orbutil.fsm.Guard.Result;
import com.sun.crypto.provider.RSACipher;

public class Login extends HttpServlet {
	
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws HTTPException,IOException {
		// get the paramter
		String username = request.getParameter("username");
		String passwd = request.getParameter("passwd");
		PrintWriter writer = response.getWriter();
		
		 try {
			Class.forName("com.mysql.jdbc.Driver");	// load database driver
			java.sql.Connection conn = DriverManager.getConnection("jdbc:mysql://192.168.50.131:3306/test1?useUnicode=true&characterEncoding=utf-8", 
					"webuser", "datang");
			//java.sql.Statement stmt = conn.createStatement();
			//java.sql.PreparedStatement pstmt = conn.prepareStatement("select * from t_class where id>4");
			
			java.sql.CallableStatement cstmt = conn.prepareCall("{call sp_test(?)}");
			for (int i = 0; i < 3; i++) {
				cstmt.setInt(1, i+3);
				ResultSet rs = cstmt.executeQuery();
				while (rs.next()) {
					writer.println(rs.getString(1) + " " + rs.getString(2));
				}
				rs.close();
			}
			
			
//			ResultSet rs = stmt.executeQuery("select * from t_calss where id>4");
			
			
			
			cstmt.close();
			conn.close();
			
		} catch (SQLException | ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		writer.close();
	}
	
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws HTTPException,IOException {
		doGet(request, response);
	}
	
}
