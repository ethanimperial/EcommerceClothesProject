<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Enter your Feedback here!</title>
</head>
<body>
	<form action="FeedbackServlet" method="post">
		 Feedback: <input type='text' name='Feedback'>
		 <input type="submit" value='Call Servlet'>
	</form>
</body>
</html>