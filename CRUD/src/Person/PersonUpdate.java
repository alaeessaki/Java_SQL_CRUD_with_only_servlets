package Person;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class PersonUpdate
 */
@WebServlet("/PersonUpdate")
public class PersonUpdate extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public PersonUpdate() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
			
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		
		int id = Integer.parseInt(request.getParameter("id"));
		
		String dbname = "ninjadb";
		String url = "jdbc:mysql://localhost/"+dbname+"?useSSL=false";
		String user = "root";
		String pass = "";
		out.println("<!doctype html>\r\n" + 
				"<html lang=\"en\">\r\n" + 
				"\r\n" + 
				"<head>\r\n" + 
				"    <meta charset=\"UTF-8\">\r\n" + 
				"    <meta name=\"viewport\"\r\n" + 
				"        content=\"width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0\">\r\n" + 
				"    <meta http-equiv=\"X-UA-Compatible\" content=\"ie=edge\">\r\n" + 
				"    <link rel=\"stylesheet\" href=\"https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css\"\r\n" + 
				"        integrity=\"sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T\" crossorigin=\"anonymous\">\r\n" + 
				"    <title>Document</title>\r\n" + 
				"</head>\r\n" + 
				"\r\n" + 
				"<body>\r\n" + 
				"\r\n" + 
				"    <div class=\"container mt-3\">\r\n" + 
				"        <div class=\"row\">\r\n" + 
				"            <div class=\"col-md-2\"></div>\r\n" + 
				"            <div class=\"col-md-8\">\r\n" + 
				"                <div class=\"text-center\">\r\n" + 
				"                    <h1>Update Person</h1>\r\n" + 
				"                </div>\r\n" + 
				"\r\n" + 
				"                <a name=\"\" id=\"\" class=\"btn btn-sm btn-secondary mb-2\" href=\"/CRUD/Person\" role=\"button\">Back</a>"); 
				try {
					Class.forName("com.mysql.jdbc.Driver");
					Connection con = DriverManager.getConnection(url,user,pass);
					
					String query = "SELECT * FROM employees WHERE id=?";
					
					PreparedStatement preparedStatement = con.prepareStatement(query);
					preparedStatement.setInt(1, id);
					ResultSet rs =preparedStatement.executeQuery();
					
					if(rs.next()) {
						out.println("				                <form action=\"PersonUpdate\" method=\"POST\">" + 
								"				                    <div class=\"form-group\">" + 
								"				                   <label for=\"nom\">Nom :</label>"
																	+"<input type=\"hidden\" value="+id+" name=\"id\" class=\"form-control\">" + 
																	  "<input type=\"text\" name=\"nom\" id=\"nom\" class=\"form-control\" placeholder=\"Nom\" aria-describedby=\"helpId\" value="+rs.getString("nom")+">" +
								"				                      <label for=\"prenom\">Prenom :</label>" + 
								"				                      <input type=\"text\" name=\"prenom\" id=\"prenom\" class=\"form-control\" placeholder=\"prenom\" aria-describedby=\"helpId\" value="+rs.getString("prenom") +">" + 
								"				                      <label for=\"CIN\">CIN :</label>" + 
								"				                   <input type=\"text\" name=\"CIN\" id=\"CIN\" class=\"form-control\" placeholder=\"CIN\" aria-describedby=\"helpId\" value="+rs.getString("CIN") +">" + 
								"				                     <div class=\"text-right mt-2\">" + 
								"				                       <button type=\"submit\" class=\"btn btn-success\">Update</button>" + 
								"				                        <button type=\"reset\" class=\"btn btn-warning\">Reset</button>" + 
								"				                      </div>" + 
								"				                    </div>" + 
								"				                </form>");
					}
					
				}catch(Exception e) {
					out.println(e);
				}

				out.println("            </div>\r\n" + 
				"        </div>\r\n" + 
				"    </div>\r\n" + 
				"\r\n" + 
				"\r\n" + 
				"\r\n" + 
				"    <script src=\"https://code.jquery.com/jquery-3.3.1.slim.min.js\"\r\n" + 
				"        integrity=\"sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo\"\r\n" + 
				"        crossorigin=\"anonymous\"></script>\r\n" + 
				"    <script src=\"https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js\"\r\n" + 
				"        integrity=\"sha384-UO2eT0CpHqdSJQ6hJty5KVphtPhzWj9WO1clHTMGa3JDZwrnQq4sF86dIHNDz0W1\"\r\n" + 
				"        crossorigin=\"anonymous\"></script>\r\n" + 
				"    <script src=\"https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js\"\r\n" + 
				"        integrity=\"sha384-JjSmVgyd0p3pXB1rRibZUAYoIIy6OrQ6VrjIEaFf/nJGzIxFDsf4x0xIM+B07jRM\"\r\n" + 
				"        crossorigin=\"anonymous\"></script>\r\n" + 
				"</body>\r\n" + 
				"\r\n" + 
				"</html>");
		
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		
		int id = Integer.parseInt(request.getParameter("id"));
		String nom = request.getParameter("nom");
		String prenom = request.getParameter("prenom");
		String CIN = request.getParameter("CIN");
		
		String dbname = "ninjadb";
		String url = "jdbc:mysql://localhost/"+dbname+"?useSSL=false";
		String user = "root";
		String pass = "";
		
		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection con = DriverManager.getConnection(url,user,pass);
			
			String query = "UPDATE `employees` SET `nom` = ?, `prenom` = ?, `CIN` = ? WHERE `employees`.`id` = ?";
			
			PreparedStatement preparedStatement = con.prepareStatement(query);
			preparedStatement.setString(1, nom);
			preparedStatement.setString(2, prenom);
			preparedStatement.setString(3, CIN);
			preparedStatement.setInt(4, id);
			
			preparedStatement.execute();
			
			response.sendRedirect("/CRUD/Person");
			
		}catch(Exception e) {
			out.println(e);
		}
		
	}

}
