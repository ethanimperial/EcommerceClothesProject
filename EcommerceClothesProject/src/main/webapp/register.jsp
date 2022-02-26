<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css"
	integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T"
	crossorigin="anonymous">

<meta charset="ISO-8859-1">
<title>Register</title>

<%@include file="/include/navbar.jsp"%>
</head>
<body>
	<div class="container">
		<div class="card w-50 mx-auto my-5">
			<div class="card-header text-center">Register</div>
			<div class="card-body">
				<form action="RegisterServlet" method="post">
					Name: <input type="text" name="userName" class="form-control"><br>
					Password: <input type="password" name="password" class="form-control"><br>
					Email: <input type="text" name="email" class="form-control"><br> 
					Address: <input type="text" name="address" class="form-control"><br>
					<div class="text-center">
						<button type="submit" value="Register" class="btn btn-primary">Register</button>
					</div>
				</form>
			</div>
		</div>
	</div>
</body>
</html>