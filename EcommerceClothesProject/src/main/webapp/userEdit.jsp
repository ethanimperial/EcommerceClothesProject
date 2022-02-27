<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<title>Feedback Management Application</title>
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css"
	integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T"
	crossorigin="anonymous">
</head>
<body>

	<nav class="navbar navbar-expand-md navbar-light">
		<div>
			<a class="navbar-brand"> Feedback Management Application </a>
		</div>
		<ul class="navbar-nav">
			<li><a
				href="<%=request.getContextPath()%>/R2FeedbackServlet/dashboard"
				class="nav-link">Back to Dashboard</a></li>
		</ul>
	</nav>
	<div class="container col-md-6">
		<div class="card">
			<div class="card-body">
				<c:if test="${feedback != null}">
					<form action="update" method="post">
				</c:if>
				<c:if test="${feedback == null}">
					<form action="insert" method="post">
				</c:if>
				
				<caption>
				
					<h2>
						<c:if test="${feedback != null}">
	Edit Feedback
	</c:if>
						<c:if test="${feedback == null}">
	Add New Feedback
	</c:if>  
					</h2>
				</caption>
				<c:if test="${feedback != null}">
					<input type="hidden" name="id"
						value="<c:out
	value='${feedback.id}' />" />
				</c:if>


				<fieldset class="form-group">
					<label>Feedback</label> <input type="text"
						value="<c:out
	value='' />"
						class="form-control" name="feedback" required="required">
				</fieldset>

				<button type="submit" class="btn btn-success" name='save'>Save</button>
				</form>
			</div>
		</div>
	</div>

</body>
</html>
