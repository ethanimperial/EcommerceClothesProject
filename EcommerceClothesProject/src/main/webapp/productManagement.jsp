<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>


<!DOCTYPE html>
<html>
<head>

<meta name="viewport" content="width=device-width, initial-scale=1">
<style>
.card-top {
	position: relative;
	display: flex;
	flex-direction: column;
	min-width: 0;
	word-wrap: break-word;
	background: #fff;
	background-clip: border-box;
	border: 1px solid rgba(0, 0, 0, 0.2);
	border-radius: .25rem;
}

h1 {
	text-align-last: center;
}

h2 {
	text-align-last: center;
}

.item img {
	width: 64px;
}

.item {
	margin: 0px 15px;
	text-align: center;
}

.item a:hover {
	color: blue;
}

.card {
	padding: 10px;
	margin: 30px;
	transition: 0.6s;
	box-shadow: 0 4px 8px 0 rgba(0, 0, 0, 0.555);
}

.card:hover {
	transition: 1.0s;
	transform: scale(1.1);
}

.card img {
	margin-bottom: 15px;
	transition: 0.3s ease-in-out;
	display: block;
	margin-left: auto;
	margin-right: auto;
	width: 80%;
}

.card img:hover {
	transition: 0.3s ease-in-out;
	transform: scale(1.1);
}

.center {
	display: flex;
	justify-content: center;
	align-items: center;
}
</style>


<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css"
	integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T"
	crossorigin="anonymous">

<meta charset="ISO-8859-1">
<title>ECommerce Application</title>

</head>
<body>
<%@include file="/include/navbar.jsp"%>

	<hr>
	<h3 class="text-center">Edit Products</h3>
	<div class="container text-left">
		<!-- Add new user button redirects to the register.jsp page -->
		<a href="<%=request.getContextPath()%>/AddProduct.jsp" class="center">Add
			New Product</a>
	</div>

	<br>

	<div class="container">
		<div class="row">
			<c:forEach var="product" items="${listProducts}">
			
				<div class="card col-md-3">
				<br>
				<h3 class="center"
					style="white-space: nowrap; overflow: hidden; text-overflow: ellipsis; max-width: 100ch;">
					${product.name}</h3>
					<br>
					
					<img width="200cm" src="${product.image}" alt="">

					<p class="Lora"
						style="white-space: nowrap; overflow: hidden; text-overflow: ellipsis; max-width: 100ch;">Category:
						${product.category}</p>
					<p class="Lora">
						<strong>Price:</strong> $${product.price}
					</p>
				
					<!-- For each user in the database, Edit/Delete
buttons which invokes the edit/delete functions -->
					<td>
					<a href="edit?name=<c:out value='${product.name}'/>">Edit</a>
						&nbsp;&nbsp;&nbsp;&nbsp; 
						<a href="delete?name=<c:out value='${product.name}' />">Delete</a></td>

				</div>


			</c:forEach>
		</div>
	</div>


</body>
</html> 