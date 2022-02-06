<%@ page import="cn.techtutorial.connection.DBCon" %>
<%@ page import="cn.techtutorial.model.*" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%
    	User auth = (User) request.getSession().getAttribute("auth");
    	if(auth!=null){
    		request.setAttribute("auth", auth);
    	}
    %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

	<%@include file="include/navbar.jsp"%>
	
	<h1>Welcome to E-commerce Clothes!</h1>

</body>
</html>