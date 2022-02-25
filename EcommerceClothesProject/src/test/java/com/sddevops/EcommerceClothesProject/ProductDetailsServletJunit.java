package com.sddevops.EcommerceClothesProject;

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
 * Servlet implementation class ProductDetailsServletJunit
 */
@WebServlet("/ProductDetailsServletJunit")
public class ProductDetailsServletJunit extends HttpServlet {
	
	private static String jdbcURL = "jdbc:mysql://localhost:3306/ecommerceproject";
	private static String jdbcUsername = "root";
	private static String jdbcPassword = "password";

	private static final String INSERT_PRODUCTS_SQL = "INSERT INTO Products" + " (name, image, price, category) VALUES "
			+ " (?, ?, ?);";
	private static final String SELECT_PRODUCT_BY_ID = "select name,image,price,category,id from Products where name =?";
	private static final String SELECT_ALL_PRODUCTS = "select * from Products ";
	public static final String DELETE_PRODUCTS_SQL = "delete from Products where name = ?;";
	private static final String UPDATE_PRODUCTS_SQL = "update Products set name = ?,image= ?, price =?,category =? where name = ?;";

	protected static Connection getConnection() {
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
	public ProductDetailsServletJunit() {
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
			case "/ProductDetailsServlet/delete":
				deleteProduct(request, response);
				break;
			case "/ProductDetailsServlet/edit":
				showEditForm(request, response);
				break;
			case "/ProductDetailsServlet/update":
				updateProduct(request, response);
				break;
			case "/ProductDetailsServlet/dashboard":
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
		
		
	// method to get parameter, query database for existing user data and redirect
			// to user edit page
			private void showEditForm(HttpServletRequest request, HttpServletResponse response)
					throws SQLException, ServletException, IOException {
				// get parameter passed in the URL
				String name = request.getParameter("name");
				ProductJunit existingProduct = new ProductJunit(0,"",0.00,"","");
				// Step 1: Establishing a Connection
				try (Connection connection = getConnection();
						// Step 2:Create a statement using connection object
						PreparedStatement preparedStatement = connection.prepareStatement(SELECT_PRODUCT_BY_ID);) {
					preparedStatement.setString(1, name);
					// Step 3: Execute the query or update query
					ResultSet rs = preparedStatement.executeQuery();
					// Step 4: Process the ResultSet object
					while (rs.next()) {
						name = rs.getString("name");
						double price = rs.getDouble("price");
						String category = rs.getString("category");
						String image = rs.getString("image");
						int id = 0; rs.getInt("id");
						existingProduct = new ProductJunit(id, name, price, category, image);
					}
				} catch (SQLException e) {
					System.out.println(e.getMessage());
				}
				// Step 5: Set existingUser to request and serve up the userEdit form
				request.setAttribute("product", existingProduct);
				request.getRequestDispatcher("/productEdit.jsp").forward(request, response);
			}
			
			
			// method to update the user table base on the form data
			private void updateProduct(HttpServletRequest request, HttpServletResponse response)
					throws SQLException, IOException {
				// Step 1: Retrieve value from the request
				String oriName = request.getParameter("oriName");
				String name = request.getParameter("name");
				String price = request.getParameter("price");
				String category = request.getParameter("category");
				String image = request.getParameter("image");

				// Step 2: Attempt connection with database and execute update user SQL query
				try (Connection connection = getConnection();
						PreparedStatement statement = connection.prepareStatement(UPDATE_PRODUCTS_SQL);) {
					statement.setString(1, name);
					statement.setString(2, image);
					statement.setString(3, price);
					statement.setString(4, category);
					statement.setString(5, oriName);
					int i = statement.executeUpdate();
				}

				response.sendRedirect("http://localhost:8090/EcommerceClothesProject/ProductDetailsServlet/dashboard");
			}
			
			// method to delete user
			public static void deleteProduct(HttpServletRequest request, HttpServletResponse response)
					throws SQLException, IOException {
				// Step 1: Retrieve value from the request
				String name = request.getParameter("name");
				// Step 2: Attempt connection with database and execute delete user SQL query
				try (Connection connection = getConnection();
						PreparedStatement statement = connection.prepareStatement(DELETE_PRODUCTS_SQL);) {
					statement.setString(1, name);
					int i = statement.executeUpdate();
				}
				// Step 3: redirect back to UserServlet dashboard (note: remember to change the
				// url to your project name)
			
				
				response.sendRedirect("http://localhost:8090/EcommerceClothesProject/ProductDetailsServlet/dashboard");
			}

			
	

	// Step 5: listUsers function to connect to the database and retrieve all users
	// records
	public static void listProducts(HttpServletRequest request, HttpServletResponse response)
			throws SQLException, IOException, ServletException {
		List<ProductJunit> products = new ArrayList<>();
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
				products.add(new ProductJunit(id, name, price, image, category));
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
