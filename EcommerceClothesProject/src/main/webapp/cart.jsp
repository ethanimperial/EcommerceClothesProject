<%@page import="ec.cart.connection.DbCon"%>
<%@page import="ec.cart.model.*"%>
<%@page import="ec.cart.dao.*"%>
<%@page import="java.util.*"%>

<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
     <%

ArrayList<Cart> cart_list = (ArrayList<Cart>) session.getAttribute("cart-list");
List<Cart> cartProduct = null;
if (cart_list != null) {
	ProductDao pDao = new ProductDao(DbCon.getConnection());
	cartProduct = pDao.getCartProducts(cart_list);
	double total = pDao.getTotalCartPrice(cart_list);
	request.setAttribute("total", total);
	request.setAttribute("cart_list", cart_list);
}



%>
<!DOCTYPE html>
<html>
<head>
<%@include file="/include/head.jsp"%>

<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<%@include file="/include/footer.jsp"%>

<%@include file="/include/navbar.jsp"%>

<div class="container">
		<div class="d-flex py-3"><h3>Total Price: $ ${ (total>0)?total:0 } </h3>
		 <a class="mx-3 btn btn-primary" name= "check" href="CheckOutServlet">Check Out</a></div>
		<table class="table table-light">
			<thead>
				<tr>
					<th scope="col">Name</th>
					<th scope="col">Category</th>
					<th scope="col">Price</th>
					<th scope="col">Buy Now</th>
					<th scope="col">Cancel</th>
				</tr>
			</thead>
			<tbody>
			
				<%
				if(cart_list != null){
					for(Cart c:cartProduct){%>
						
						<tr>
						<td><%= c.getName() %></td>
						<td><%= c.getCategory() %></td>
						<td><%= c.getPrice() %></td>
						<td>
							<form action="order-now" method="post" class="form-inline">
							<input type="hidden" name="id" value="<%= c.getId() %>" class="form-input">
								<div class="form-group d-flex justify-content-between">
									<a class="btn bnt-sm btn-incre" name= "incre" href="QuantityServlet?action=inc&id=<%=c.getId()%>"><i class="fas fa-plus-square"></i></a> 
									<input type="text" name="quantity" class="form-control"  value="<%=c.getQuantity()%>" readonly> 
									<a class="btn btn-sm btn-decre" name= "decre" href="QuantityServlet?action=dec&id=<%=c.getId()%>"><i class="fas fa-minus-square"></i></a>
								</div>
							</form>
						</td>
						<td><a href="RemoveFromCartServlet?id=<%=c.getId() %>" class="btn btn-sm btn-danger" name= "remove">Remove</a></td>
					</tr>

						
					<%}
				}
				%>
			
				
				
			</tbody>
		</table>
	</div>
	


</body>
