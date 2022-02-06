package ec.cart.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import ec.cart.model.*;
/**
 * Servlet implementation class AddToCartServlet
 */
@WebServlet("/AddToCartServlet")
public class AddToCartServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		 try (PrintWriter out = response.getWriter()) {
//	        	out.print("add to cart servlet");

	            ArrayList<Cart> cartList = new ArrayList<>();
	            int id = Integer.parseInt(request.getParameter("id"));
	            Cart cm = new Cart();
	            cm.setId(id);
	            cm.setQuantity(1);
	            HttpSession session = request.getSession();
	            ArrayList<Cart> cart_list = (ArrayList<Cart>) session.getAttribute("cart-list");
	            
	            if(cart_list == null){
	            	cartList.add(cm);
	            	session.setAttribute("cart-list" , cartList);
	            	response.sendRedirect("Home.jsp");
	            }else {
	            	cartList = cart_list;
	            	boolean exist = false;
	            	
	            	for(Cart c:cartList) {
	            		if(c.getId() == id) {
	            			exist= true;
	            			 out.println("Item Already in Cart");
	            		}
	            		
	            	}
	            	if(!exist) {
		            	cartList.add(cm);
		            	response.sendRedirect("Home.jsp");
		            }
	            }
	            
	           
	}
	}
}
