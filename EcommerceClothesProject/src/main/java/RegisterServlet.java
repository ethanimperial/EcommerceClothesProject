

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

/**
 * Servlet implementation class RegisterServlet
 */
@WebServlet("/RegisterServlet")
public class RegisterServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public RegisterServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		
		//Step 1: Initialize a PrintWriter object to return the html values via the response
		PrintWriter out = response.getWriter();
		
		//Step 2: retrieve the four parameters from the request from the web form
		String n = request.getParameter("userName");
		String p = request.getParameter("password");
		String e = request.getParameter("email");
		String c = request.getParameter("address");
		String sql = request.getParameter("email");
		
		//Step 3: attempt connection to database using JDBC, you can change the username and password accordingly using the phpMyAdmin > User Account dashboard
		try {
		 Class.forName("com.mysql.jdbc.Driver");
		 Connection con = DriverManager.getConnection(
		 "jdbc:mysql://localhost:3306/ecommerceproject", "root", "password");
		 
		//Step 4: implement the sql query using prepared statement (https://docs.oracle.com/javase/tutorial/jdbc/basics/prepared.html)
		 PreparedStatement ps = con.prepareStatement("insert into USERSSTUFF (name, password, email, address) values(?,?,?,?)");
		 PreparedStatement sqlStuff = con.prepareStatement("select email from usersstuff where email = ?");
		 
		//Step 5: parse in the data retrieved from the web form request into the prepared statement accordingly
		 ps.setString(1, n);
		 ps.setString(2, p);
		 ps.setString(3, e);
		 ps.setString(4, c);
		 sqlStuff.setString(1, e);
		 
		//Step 6: perform the query on the database using the prepared statement
		 ResultSet i = sqlStuff.executeQuery();
		 
		 boolean hasResult = i.next();
		 
		//Step 7: check if the query had been successfully execute, return ?You are successfully registered? via the response,
		 if (!hasResult){
			 int abc = ps.executeUpdate();/////
			 
			//Step 7: check if the query had been successfully execute, return ?You are successfully registered? via the response,
			 if (abc > 0){
				 	PrintWriter writer = response.getWriter();
				 	writer.println(
				 			"<h1>" + "You have successfully registered an account!" + "</h1>" + 
				 			"<a href='login.jsp'>" + "Login now!" + "</a>"
				 			);
				 	writer.close();
			 }
			 
		 } else {
			 PrintWriter writer = response.getWriter();
			 	writer.println(
			 			"<h1>" + "There is already an account registered to this email, please try another email." + "</h1>" + 
			 			"<a href='register.jsp'>" + "Try another email this time." + "</a>"
			 			);
			 	writer.close();
		 }
		 
		}
		//Step 8: catch and print out any exception
		catch (Exception exception) {
		 System.out.println(exception);
		 out.close();
		}

		
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}