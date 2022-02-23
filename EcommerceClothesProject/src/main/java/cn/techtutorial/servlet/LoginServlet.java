package cn.techtutorial.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.techtutorial.connection.DBCon;
import cn.techtutorial.dao.UserDao;
import cn.techtutorial.model.User;

/**
 * Servlet implementation class LoginServlet
 */
@WebServlet("/user-login")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private static final String SELECT_ALL_USERS = "select * from usersstuff ";

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html; charset=UTF-8");

		String p = request.getParameter("login-password");
		String e = request.getParameter("login-email");

		String id = request.getParameter("id");
		
		PrintWriter out = response.getWriter();
		try{
			
			Class.forName("com.mysql.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/ecommerceproject", "root", "password");

			// Step 4: implement the sql query using prepared statement
			// (https://docs.oracle.com/javase/tutorial/jdbc/basics/prepared.html)
			PreparedStatement ps = con.prepareStatement("select * from usersstuff where email = ? and password = ?");

			// Step 5: parse in the data retrieved from the web form request into the
			// prepared statement accordingly
			ps.setString(1, e);
			ps.setString(2, p);

			// Step 6: perform the query on the database using the prepared statement
			ResultSet i = ps.executeQuery();

			boolean hasResult = i.next();

			// Step 7: check if the query had been successfully execute, return “You are
			// successfully registered” via the response,
			if (hasResult) {
				// Step 7: check if the query had been successfully execute, return “You are
				// successfully registered” via the response,
				id = i.getString("id");
				request.getSession().setAttribute("currentUser", id);
				response.sendRedirect("Home.jsp");		 
			} else {
				out.println("Your username or password is incorrect, please try again." + "<br>"
						+ "<a href='login.jsp'>" + "Try again." + "</a>");

			}

		}
		// Step 8: catch and print out any exception
		catch (Exception exception) {
			System.out.println(exception);
			out.close();
		}
		// TODO Auto-generated method stub
				doGet(request, response);
	}

}