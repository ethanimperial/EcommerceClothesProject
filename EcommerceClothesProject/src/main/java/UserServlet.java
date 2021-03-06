

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.RequestDispatcher;

/**
 * Servlet implementation class UserServlet
 */
@WebServlet("/UserServlet")
public class UserServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	//Step 1: Prepare list of variables used for database connections
	 private String jdbcURL = "jdbc:mysql://localhost:3306/usersstuff";
	 private String jdbcUsername = "root";
	 private String jdbcPassword = "password";
	 
	 //Step 2: Prepare list of SQL prepared statements to perform CRUD to our database
	 private static final String INSERT_USERS_SQL = "INSERT INTO UserDetails" + " (name, password, email, address) VALUES " +" (? ,?, ?, ?);";
	 private static final String SELECT_USER_BY_ID = "select name,password,email,language from usersstuff where id =?";
	 private static final String SELECT_ALL_USERS = "select * from usersstuff ";
	 private static final String DELETE_USERS_SQL = "delete from usersstuff where id = ?;";
	 private static final String UPDATE_USERS_SQL = "update usersstuff set name = ?, password= ?, email =?,address =? where id = ?;";
	 
	 //Step 3: Implement the getConnection method which facilitates connection to the database via JDBC
	 protected Connection getConnection() {
	 Connection connection = null;
	 try {
		 Class.forName("com.mysql.jdbc.Driver");
		 	connection = DriverManager.getConnection(jdbcURL, jdbcUsername, jdbcPassword);
	 } catch (SQLException e) {
	 	e.printStackTrace();
	 } catch (ClassNotFoundException e) {
	 	e.printStackTrace();
	 }
	 return connection;
}
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UserServlet() {
    	super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		//Step 4: Depending on the request servlet path, determine the function to invoke using the follow switch statement.
		String action = request.getServletPath();
		 try {
			 switch (action) {
			 	case "/insert":
			 		break;
			 	case "/delete":
			 		break;
			 	case "/edit":
			 		break;
			 	case "/update":
			 		break;
			 	default:
			 		listCurrentUser(request, response);
			 		break;
		 	}
		 } catch (SQLException ex) {
		 throw new ServletException(ex);
		 }
		
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}
	
	private void listCurrentUser(HttpServletRequest request, HttpServletResponse response)
	throws SQLException, IOException, ServletException
	{}

}
