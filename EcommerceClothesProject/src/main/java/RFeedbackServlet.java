
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.RequestDispatcher;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class RFeedbackServlet
 */
@WebServlet("/RFeedbackServlet")
public class RFeedbackServlet extends HttpServlet {

	// Step 1: Prepare list of variables used for database connections
	private String jdbcURL = "jdbc:mysql://localhost:3306/user_feedback";
	private String jdbcUsername = "root";
	private String jdbcPassword = "password"; 

	// Step 2: Prepare list of SQL prepared statements to perform CRUD to our
	// database
	private static final String INSERT_Feedbacks_SQL = "INSERT INTO UserFeedbacks" + " (Feedback) VALUES " + " (?);";
	private static final String SELECT_Feedback_BY_ID = "select id, Feedback from UserFeedbacks where id =?";
	private static final String SELECT_ALL_Feedbacks = "select * from userfeedbacks ";
	private static final String DELETE_Feedbacks_SQL = "delete from UserFeedbacks where id = ?;";
	private static final String UPDATE_Feedbacks_SQL = "update UserFeedbacks set Feedback = ? where id = ?;";

	// Step 3: Implement the getConnection method which facilitates connection to
	// the database via JDBC
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
	public RFeedbackServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

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

			case "/RFeedbackServlet/edit":
				showEditForm(request, response);
				break;

			case "/RFeedbackServlet/update":
				updateFeedback(request, response);
				break;

			case "/RFeedbackServlet/dashboard":
				listFeedbacks(request, response);
				break;

			}
		} catch (SQLException ex) {
			throw new ServletException(ex);
		}

		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		// TODO Auto-generated method stub
		doGet(request, response);
	}

	// Step 5: listFeedbacks function to connect to the database and retrieve all
	// feedbacks
	// records
	private void listFeedbacks(HttpServletRequest request, HttpServletResponse response)
			throws SQLException, IOException, ServletException {
		List<RFeedback> feedbacks = new ArrayList<>();
		try (Connection connection = getConnection();
				// Step 5.1: Create a statement using connection object
				PreparedStatement preparedStatement = connection.prepareStatement(SELECT_ALL_Feedbacks);) {
			// Step 5.2: Execute the query or update query
			ResultSet rs = preparedStatement.executeQuery();
			// Step 5.3: Process the ResultSet object.
			while (rs.next()) {
				int id =  rs.getInt("id");
				String Feedback = rs.getString("Feedback");
				feedbacks.add(new RFeedback(id, Feedback));
			}
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
		// Step 5.4: Set the feedback list into the listFeedbacks attribute to be pass
		// to the
		// feedbackManagement.jsp
		request.setAttribute("listFeedbacks", feedbacks);
		request.getRequestDispatcher("/feedbackManagement.jsp").forward(request, response);
	}

	// method to get parameter, query database for existing user data and redirect
	// to user edit page
	private void showEditForm(HttpServletRequest request, HttpServletResponse response)
			throws SQLException, ServletException, IOException {
		// get parameter passed in the URL
		String name = request.getParameter("name");
		RFeedback existingFeedback = new RFeedback(0, "");

		// Step 1: Establishing a Connection
		try (Connection connection = getConnection();

				// Step 2:Create a statement using connection object
				PreparedStatement preparedStatement = connection.prepareStatement(SELECT_Feedback_BY_ID);) {
			preparedStatement.setString(1, name);

			// Step 3: Execute the query or update query
			ResultSet rs = preparedStatement.executeQuery();

			// Step 4: Process the ResultSet object
			while (rs.next()) {
				int id =  rs.getInt("id");
				String feedback = rs.getString("feedback");
				existingFeedback = new RFeedback(id, feedback);
				
			}
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}

		// Step 5: Set existingUser to request and serve up the userEdit form
		request.setAttribute("feedback", existingFeedback);
		request.getRequestDispatcher("/userEdit.jsp").forward(request, response);
	}
	

	// method to update the feedback table base on the form data
	private void updateFeedback(HttpServletRequest request, HttpServletResponse response)
			throws SQLException, IOException {
		// Step 1: Retrieve value from the request
		String feedback = request.getParameter("feedback");
		String id = request.getParameter("id");

		// Step 2: Attempt connection with database and execute update feedback SQL
		// query
		try (Connection connection = getConnection();
				PreparedStatement statement = connection.prepareStatement(UPDATE_Feedbacks_SQL);) {
			statement.setString(1, feedback);
			statement.setString(2, id);
			int i = statement.executeUpdate();
		}
		// Step 3: redirect back to RFeedbackServlet (note: remember to change the url
		// to your project name)
		response.sendRedirect("http://localhost:8080/EcommerceClothesProject/RFeedbackServlet/dashboard"); 
	}

}
