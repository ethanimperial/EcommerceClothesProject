<nav class="navbar navbar-expand-lg navbar-light bg-light">
	<div class="container">
		<a class="navbar-brand" href="login.jsp">E-Commerce Clothes</a>
		<button class="navbar-toggler" type="button" data-toggle="collapse"
			data-target="#navbarSupportedContent"
			aria-controls="navbarSupportedContent" aria-expanded="false"
			aria-label="Toggle navigation">
			<span class="navbar-toggler-icon"></span>
		</button>
		
		<%
HttpSession sessions = request.getSession();
%>
<%
String lolmao= (String) sessions.getAttribute("currentUser");
%>

	
		<div class="collapse navbar-collapse" id="navbarSupportedContent">
			<ul class="navbar-nav ml-auto">
        			<%if(lolmao != null){%>
		<li class="nav-item"><a class="nav-link" href="http://localhost:8090/EcommerceClothesProject/Home.jsp">Home</a></li>
					<li class="nav-item"><a class="nav-link" href="http://localhost:8090/EcommerceClothesProject/ProductDetailsServlet/dashboard">Admin</a></li>
					<li class="nav-item"><a class="nav-link" href="http://localhost:8090/EcommerceClothesProject/cart.jsp">Cart</a></li>
					<li class="nav-item"><a class="nav-link" href="http://localhost:8090/EcommerceClothesProject/UserServlet/dashboard">Account</a></li>
					<li class="nav-item"><a class="nav-link" href="log-out">Log out</a></li>
				<%}else{ %>
					<li class="nav-item"><a class="nav-link" href="login.jsp">Login</a></li>
				<%}%>	
			</ul>
		</div>
	</div>
</nav> 