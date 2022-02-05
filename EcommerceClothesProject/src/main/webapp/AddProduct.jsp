<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<title>User Management Application</title>
 <link rel="stylesheet"
href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css"
integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T"
crossorigin="anonymous">


<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>

<nav class="navbar navbar-expand-md navbar-light">
		<div>
			<a class="navbar-brand"> Product Management Application </a>
		</div>
		<ul class="navbar-nav">
			<li><a
				href="<%=request.getContextPath()%>/ProductDetailsServlet/dashboard"
				class="nav-link">Back to Dashboard</a></li>
		</ul>
	</nav>
	

<body>

<div class="container col-md-6">
		<div class="card">
			<div class="card-body">
			
				<h2>
						<c:if test="${product != null}">
Edit Product
</c:if>
						<c:if test="${product == null}">
Add New Product
</c:if>
					</h2>
				
					<form action="ProductServlet" method="post">
				
				
				
				<fieldset class="form-group">
					<label>Product Title</label> <input type="text"
						value="<c:out
value='Enter Product Name' />" class="form-control"
						name="name" required="required">
				</fieldset>
				
						<fieldset class="form-group">
					<label>Image</label> <input type="text"
						value="<c:out
value='Insert Image Address' />" class="form-control"
						name="image">
				</fieldset>
				
				
				<fieldset class="form-group">
					<label>Price</label> <input type="text"
						value="<c:out
value='Enter Product Price' />" class="form-control"
						name="price">
				</fieldset>
				
				
				<fieldset class="form-group">
					<label>Category</label> <input type="text"
						value="<c:out
value='Enter Product Category' />" class="form-control"
						name="category">
				</fieldset>
				
				
		
				
							
				
				
				<button type="submit" class="btn btn-success">Save</button>
				</form>
			</div>
		</div>
	</div>



</body>
</html>