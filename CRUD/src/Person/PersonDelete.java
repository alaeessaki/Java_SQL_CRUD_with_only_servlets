package Person;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class PersonDelete
 */
@WebServlet("/PersonDelete")
public class PersonDelete extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public PersonDelete() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		String dbname = "ninjadb";
		String url = "jdbc:mysql://localhost/"+dbname+"?useSSL=false";
		String user = "root";
		String pass = "";
		
		int id = Integer.parseInt(request.getParameter("id"));
		
		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection con = DriverManager.getConnection(url,user,pass);
			
			String query = "DELETE FROM employees WHERE id=?";
			PreparedStatement preparedStatement = con.prepareStatement(query);
			preparedStatement.setInt(1, id);
			preparedStatement.execute();
			response.sendRedirect("/CRUD/Person");
			
			
		}catch(Exception e) {
			out.println(e);
		}
		
	
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
