<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<form action="ProductServlet" method="post" >
Product: <input type ="text" name="name">
Image: <input type ="text" name="image">
Price: <input type ="text" name="price">
Category: <input type ="text" name="category">
<input type ="submit" value="Call Servlet"/>

</form>

</body>
</html>