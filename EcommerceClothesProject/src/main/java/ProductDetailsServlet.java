

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
import javax.servlet.http.Cookie;




/**
 * Servlet implementation class ProductDetailsServlet
 */
@WebServlet("/ProductDetailsServlet")
public class ProductDetailsServlet extends HttpServlet {

	private String jdbcURL = "jdbc:mysql://localhost:3306/ecommerceproject";
	private String jdbcUsername = "root";
	private String jdbcPassword = "password";

	private static final String INSERT_PRODUCTS_SQL = "INSERT INTO Products" + " (name, image, price, category) VALUES "
			+ " (?, ?, ?);";
	private static final String SELECT_PRODUCT_BY_ID = "select name,image,price,category,id from Products where name =?";
	private static final String SELECT_ALL_PRODUCTS = "select * from Products ";
	private static final String DELETE_PRODUCTS_SQL = "delete from Products where name = ?;";
	private static final String UPDATE_PRODUCTS_SQL = "update Products set name = ?,image= ?, price =?,category =? where name = ?;";

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

	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public ProductDetailsServlet() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	int added_cart_product = 0;
	
	Cookie c = null;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

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
		 listProducts(request, response);
		 break;
		 }
		 } catch (SQLException ex) {
		 throw new ServletException(ex);
		 }
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}
	
	// method to get parameter, query database for existing user data and redirect
		// to user edit page
		
		
	

	// Step 5: listUsers function to connect to the database and retrieve all users
	// records
	private void listProducts(HttpServletRequest request, HttpServletResponse response)
			throws SQLException, IOException, ServletException {
		List<Product> products = new ArrayList<>();
		try (Connection connection = getConnection();
				// Step 5.1: Create a statement using connection object
				PreparedStatement preparedStatement = connection.prepareStatement(SELECT_ALL_PRODUCTS);) {
			// Step 5.2: Execute the query or update query
			ResultSet rs = preparedStatement.executeQuery();
			// Step 5.3: Process the ResultSet object.
			while (rs.next()) {
				String name = rs.getString("name");
				String image = rs.getString("image");
				double price = rs.getDouble("price");
				String category = rs.getString("category");
				int id = 0; rs.getInt("id");
				products.add(new Product(id, name, price, image, category));
			}
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
		// Step 5.4: Set the users list into the listUsers attribute to be pass to the
		// userManagement.jsp
		request.setAttribute("listProducts", products);
		request.getRequestDispatcher("/productManagement.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}}
