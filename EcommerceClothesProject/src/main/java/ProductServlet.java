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




/**
 * Servlet implementation class ProductServlet
 */
@WebServlet("/ProductServlet")
public class ProductServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ProductServlet() {
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
		// TODO Auto-generated method stub
		
		
	response.setContentType("text/html");
		
		PrintWriter out = response.getWriter();
		
		String n = request.getParameter("name");
		String p = request.getParameter("image");
		String e = request.getParameter("price");
		String c = request.getParameter("category");
	
		try {
		 Class.forName("com.mysql.jdbc.Driver");
		 Connection con = DriverManager.getConnection(
		 "jdbc:mysql://localhost:3306/ecommerceproject", "root", "password");
		
		 PreparedStatement ps = con.prepareStatement("insert into PRODUCTS (name,image,price,category) values(?,?,?,?)");
		
		 ps.setString(1, n);
		 ps.setString(2, p);
		 ps.setString(3, e);
		 ps.setString(4, c);
		
		
		 int i = ps.executeUpdate();
		 
		
		  if (i > 0){
			 
			  PrintWriter writer = response.getWriter();
			  writer.println("<h1>" + "You have successfully added a product!" +
			  "</h1>");
			  writer.close(); 
		 }
		 }
	
		 catch (Exception exception) {
		  System.out.println(exception);
		  out.close();
		 }
		
		
		doGet(request, response);
		
		
	}

}
