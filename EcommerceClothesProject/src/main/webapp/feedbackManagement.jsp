<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css"
	integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T"
	crossorigin="anonymous">
</head>
<body>
	<div class="row">
		<div class="container">
			<h3 class="text-center">List of Feedbacks</h3>
			<hr>
			<div class="container text-left">
				<!-- Add new feedback button redirects to the Cfeedback.jsp page -->
				<a href="<%=request.getContextPath()%>/Cfeedback.jsp"
					class="btn btn-success">Add New Feedback</a>
			</div>
			<br>
			<!-- Create a table to list out all feedbacks information -->
			<table class="table">
				<thead>  
					<tr>
						<th>Feedback</th>

						<th>Actions</th>
					</tr>
				</thead>
		
				<!-- Pass in the list of users receive via the Servlet’s response to a loop
	-->
				<tbody>
					<c:forEach var="feedback" items="${listFeedbacks}">
						<!-- For each feedback in the database, display
	information accordingly -->
						<tr>
							<td><c:out value="${feedback.feedback}" /></td>

							<!-- For each feedback in the database, Edit/Delete
	buttons which invokes the edit/delete functions -->

							<td><a
								href="edit?name=<c:out value='${feedback.id}'
	/>">Edit</a>
								&nbsp;&nbsp;&nbsp;&nbsp; <a
								href="delete?id=<c:out
	value='${feedback.id}' />">Delete</a>
							</td>

						</tr>
					</c:forEach>
				</tbody>
			</table>
		</div>
	</div>
</body>
</html>