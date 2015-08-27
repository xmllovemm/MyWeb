<?xml version="1.0" encoding="utf-8" ?>
<%@page import="bean.StudentBean" %>
<%@page import="dao.StudentDao" %>
<%@ page language="java" import="java.util.*" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<% 
String path = request.getContextPath();
String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + path;
%>


<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
	<base href="<%=basePath%>" />
	<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
	<title>student result info</title>
</head>
<body>
	查询结果页面<br/>
	<%ArrayList stuList = (ArrayList)request.getAttribute("stus"); %>
	<table>
		<tr>
			<td>学号</td>
			<td>姓名</td>
			<td>性别</td>
			<td>出生日期</td>
			<td>家庭住址</td>
		</tr>
		<%
			for(int i=0; i<stuList.size(); i++) {
				StudentBean student = (StudentBean)stuList.get(i);
		%>
			<tr>
				<td><%=student.getId() %></td>
				<td><%=student.getName() %></td>
				<td><%=student.getSex() %></td>
				<td><%=student.getBirthday() %></td>
				<td><%=student.getAddress() %></td>
			</tr>
			<%} %>
	</table>
</body>
</html>