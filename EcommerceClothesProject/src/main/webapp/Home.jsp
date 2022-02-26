<%@page import="ec.cart.connection.DbCon"%>
<%@page import="ec.cart.model.*"%>
<%@page import="ec.cart.dao.*"%>
<%@page import="java.util.*"%>

<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
     <%


ArrayList<Cart> cart_list = (ArrayList<Cart>) session.getAttribute("cart-list");
if (cart_list != null) {
	
	request.setAttribute("cart_list", cart_list);
}

ProductDao pd = new ProductDao(DbCon.getConnection());
List<Product> products = pd.getAllProducts();


%>
   

<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css"
	integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T"
	crossorigin="anonymous">

<%@include file="/include/head.jsp"%>

<meta charset="ISO-8859-1">
<title>Home</title>
</head>
<body>
<%@include file="/include/navbar.jsp"%>
<%@include file="/include/footer.jsp"%>


<div class="container">
		<div class="card-header my-3">All Products</div>
		<div class="row">
		
		<% if( !products.isEmpty()){
			for(Product p:products){	%>
				
				<div class="col-md-3 my-3">
			<div class="card w-100" style="width: 18rem;">
			<img class="card-img-top" src=<%= p.getImage() %> alt="">
			<div class="card-body">
				<h5 class="card-title"><%= p.getName() %></h5>
				<h6 class="price"><%= p.getPrice() %></h6>
				<h6 class="category"><%= p.getCategory() %></h6>
				<div class="mt-3 d-flex justify-content-between">
					<a class="btn btn-primary" href="AddToCartServlet?id=<%= p.getId() %>">Add to Cart</a> 
				</div>
			</div>
		</div>
		
	</div>
				
			<%}
		} %>
		
		
			
		</div>
	</div>



</body>
</html>