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
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css"
	integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T"
	crossorigin="anonymous">
	
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

	<%@include file="include/navbar.jsp"%>
	
	<h1>Welcome to E-commerce Clothes!</h1>
	<img src="http://s3.amazonaws.com/pix.iemoji.com/images/emoji/apple/ios-12/256/thumbs-up.png">

</body>
</html>