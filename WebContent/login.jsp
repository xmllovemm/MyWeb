<%@page import="java.util.Date"%>
<%@page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
	<title>Welcom to my web site!</title>
</head>
<body>
	<%=new java.util.Date().toString() %>
	
	<form action="login" method=post>
		用户: <input type="text" name="username" />
		<br/>
		密码: <input type="password" name="passwd" />
		<br/>
		<input type="submit" value="登录"> 
	</form>
	
	
</body>
</html>