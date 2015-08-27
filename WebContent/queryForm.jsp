<?xml version="1.0" encoding="ISO-8859-1" ?>
<%@ page language="java" import="java.util.*" contentType="text/html; charset=utf-8"%>
<% 
String path = request.getContextPath();
String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + path;
%>


<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
	<base href="<%=basePath%>" />
	<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
	<title>My JSP query form starting page</title>
</head>
<body>

	查询表单<br/>
	<form action="query.do" method="post">
		请输入学生姓名:<input name="studentName"/>
		<input type="submit" value="模糊查询"/>
	</form>

</body>
</html>