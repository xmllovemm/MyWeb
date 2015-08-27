package dao;

import java.sql.*;
import java.util.ArrayList;

import org.omg.CORBA.PUBLIC_MEMBER;

import bean.*;
import sun.print.resources.serviceui;

public class StudentDao {
	// private member
	private Connection conn = null;
	
	// function
	public void initConnection() {
		try {
			Class.forName("com.mysql.jdbc.Driver");
			conn = DriverManager.getConnection("jdbc:mysql://192.168.50.131:3306/test1?useUnicode=true&characterEncoding=utf-8", 
				"webuser", "datang");
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}
	
	public ArrayList<StudentBean> queryStudentByName(String name) {
		ArrayList<StudentBean> studentList = new ArrayList<StudentBean>();
		
		try {
			this.initConnection();
			
			PreparedStatement pstmt = conn.prepareStatement("SELECT t.id,t.name,t.sex,t.birthday,t.address FROM tb_student AS t WHERE t.name LIKE '%?%'");
			pstmt.setString(1, name);
			
			ResultSet rs = pstmt.executeQuery();
			while (rs.next()) {
				StudentBean sb = new StudentBean();
				sb.setId(rs.getInt(1));
				sb.setName(rs.getString(2));
				sb.setSex(rs.getString(3));
				sb.setBirthday(rs.getString(4));
				sb.setAddress(rs.getString(5));
			}
			
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		finally {
			this.closeConnection();
		}
			
		return studentList;
	}
	
	public void closeConnection()
	{
		if (conn != null) {
			try {
				conn.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			conn = null;
		}
	}
}
