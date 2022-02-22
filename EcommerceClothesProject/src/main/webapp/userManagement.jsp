<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css"
	integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T"
	crossorigin="anonymous">

<meta charset="ISO-8859-1">
<title>My account</title>
<%@include file="/include/navbar.jsp"%>
</head>
<body>

	<div class="row">
		<div class="container">
		<br><br>
			<h3 class="text-center">My Account</h3>
			<div class="container text-left">
				<!-- Add new user button redirects to the register.jsp page -->
				<a href="<%=request.getContextPath()%>/index.jsp"
					class="btn btnsuccess">Back</a>
			</div>
			<br>
			<!-- Create a table to list out all current users information -->
			<table class="table">
				<thead>
					<tr>
						<th>Name</th>
						<th>Email</th>
						<th>Address</th>
						<th>Actions</th>
					</tr>
				</thead>
				<!-- Pass in the list of users receive via the Servlet’s response to a loop
-->
				<tbody>
					
						<!-- For each user in the database, display their information accordingly -->
						<tr>
							<td><c:out value="${listUsers.name}" /></td>
							<td><c:out value="${listUsers.email}" /></td>
							<td><c:out value="${listUsers.address}" /></td>
							<!-- For each user in the database, Edit/Delete buttons which invokes the edit/delete functions -->
							<td><a href="edit?id=<c:out value='${listUsers.id}'
/>">Edit</a>
								&nbsp;&nbsp;&nbsp;&nbsp; <a
								href="delete?id=<c:out
value='${listUsers.id}' />">Delete</a></td>
						</tr>
				</tbody>
			</table>
		</div>
	</div>

</body>
</html>