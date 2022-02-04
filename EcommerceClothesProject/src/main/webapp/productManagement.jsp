<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css"
	integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T"
	crossorigin="anonymous">
	<body><%@include file="/include/navbar.jsp"%>
<div class="row">
	<div class="container">
		<h3 class="text-center">List of Users</h3>
		<hr>
		<div class="container text-left">
			<!-- Add new user button redirects to the register.jsp page -->
			<a href="<%=request.getContextPath()%>/AddProduct.jsp"
				class="btn btnsuccess">Add New User</a>
		</div>
		<br>
		<!-- Create a table to list out all current users information -->
		<table class="table">
			<thead>
				<tr>
					<th>Name</th>
					<th>Password</th>
					<th>Email</th>
					<th>Language</th>
					<th>Actions</th>
				</tr>
			</thead>
			<!-- Pass in the list of users receive via the Servlet’s response to a loop
-->
			<tbody>
				<c:forEach var="product" items="${listProducts}">
					<!-- For each user in the database, display their
information accordingly -->
					<tr>
						<td><c:out value="${product.name}" /></td>
						<td><c:out value="${product.image}" /></td>
						<td><c:out value="${product.price}" /></td>
						<td><c:out value="${product.category}" /></td>
						<!-- For each user in the database, Edit/Delete
buttons which invokes the edit/delete functions -->
						<td><a href="edit?name=<c:out value='${product.name}'
/>">Edit</a>
							&nbsp;&nbsp;&nbsp;&nbsp; <a
							href="delete?name=<c:out
value='${product.name}' />">Delete</a>
						</td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
	</div>
</div>

</body>