package Person;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import java.sql.Statement;
import java.sql.Connection;

/**
 * Servlet implementation class Person
 */
@WebServlet("/Person")
public class Person extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Person() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.setContentType("text/HTML");		
		PrintWriter out = response.getWriter();	
		
		String dbname = "ninjadb";
		String url = "jdbc:mysql://localhost/"+dbname+"?useSSL=false";
		String user = "root";
		String pass = "";
		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection con = DriverManager.getConnection(url,user,pass);
			
			Statement stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery("SELECT * FROM employees");
			
			out.println("<html lang=\"en\">\r\n" + 
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
					"  <div class=\"container\">\r\n" + 
					"        <div class=\"row\">\r\n" + 
					"            <div class=\"col-md-12\">\r\n" + 
					"                <div class=\"jumbotron jumbotron-fluid\">\r\n" + 
					"                    <div class=\"container\">\r\n" + 
					"                        <h1 class=\"display-3\">Welcome to Ninja DB</h1>\r\n" + 
					"                    </div>\r\n" + 
					"                </div>\r\n" + 
					"            </div>\r\n" + 
					"        </div>" + 
					"    <div class=\"container mt-3\">\r\n"
					+ "<div class=\"row\">"
					+ "<div class=\"col-6 text-left\">"
					+ "	<a type=\"button\" class=\"btn btn-secondary mb-2 btn-sm\" href=\"/CRUD\">back</a>"
					+ "</div>"
					+ "<div class=\"col-6 text-right\">"
					+ "<a type=\"button\" class=\"btn btn-success mb-2 btn-sm\" href=\"/CRUD/addPerson.html\">add Employee</a>" + 
						"</div>"
					+ "</div>" + 
					"        <div class=\"row\">"
					+ "<table class=\"table table-striped\">\r\n" + 
					"                    <thead>\r\n" + 
					"                        <tr>\r\n" + 
												 "<th scope=\"col\">Nom</th>\r\n"+
					"                            <th scope=\"col\">Nom</th>\r\n" + 
					"                            <th scope=\"col\">Prenom</th>\r\n" + 
					"                            <th scope=\"col\">CIN</th>\r\n"+
												"<th scope=\"col\"></th>" + 
					"                        </tr>\r\n" + 
					"                    </thead>\r\n" + 
					"                    <tbody>\r\n");
			while(rs.next()) {
				out.println("<tr>\r\n" + 
					"<td scope=\"row\">"+rs.getInt("id")+"</td>\r\n" +
					"<td scope=\"row\">"+rs.getString("nom")+"</td>\r\n" + 
					"<td>"+rs.getString("prenom")+"</td>\r\n" + 
					"<td>"+rs.getString("CIN")+"</td>\r\n"
							+ "<td class=\"text-right \"><a href=\"/CRUD/PersonUpdate?id="+rs.getInt("id")+ "\"\" class=\"btn btn-sm btn-warning\">update</a>\r\n" + 
							"<a href=\"/CRUD/PersonDelete?id=" +rs.getInt("id")+ "\"\" class=\"btn btn-sm btn-danger\">delete</a></td>" + 
					"</tr>\r\n");
			}
			out.println("	</tbody>\r\n" + 
						"</table>"
						+ "     </div>\r\n" + 
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
		}catch(Exception e) {
			out.println(e);
		}
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.setContentType("text/HTML");		
		PrintWriter out = response.getWriter();	
		
		String dbname = "ninjadb";
		String url = "jdbc:mysql://localhost/"+dbname+"?useSSL=false";
		String user = "root";
		String pass = "";
		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection con = DriverManager.getConnection(url,user,pass);
			
			String nom = request.getParameter("nom");
			String prenom = request.getParameter("prenom");
			String CIN = request.getParameter("CIN");
			
			String query = "INSERT INTO `employees` (`id`,`role_id`, `nom`, `prenom`, `CIN`,`dep_id`) VALUES(NULL,1,?,?,?,1)";
			PreparedStatement preparedStatement = con.prepareStatement(query);
			
			preparedStatement.setString(1, nom);
			preparedStatement.setString(2, prenom);
			preparedStatement.setString(3, CIN);
			
			preparedStatement.execute();
			
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
					"\r\n"+
					"    <div class=\"container mt-3\">\r\n" + 
					"        <div class=\"row\">\r\n" + 
					"            <div class=\"col-md-2\"></div>\r\n" + 
					"            <div class=\"col-md-8\">\r\n" + 
					"                <a name=\"\" id=\"\" class=\"btn btn-sm btn-secondary mb-2\" href=\"/CRUD/Person\" role=\"button\">Back</a>\r\n" + 
					"\r\n"
					+ "<div class=\"alert alert-success mt-2\" role=\"alert\">\r\n" + 
					" Person Added successfully" + 
					"</div>" + 
					"                <form action=\"Person\" method=\"POST\">\r\n" + 
					"                    <div class=\"form-group\">\r\n" + 
					"                      <label for=\"nom\">Nom :</label>\r\n" + 
					"                      <input type=\"text\" name=\"nom\" id=\"nom\" class=\"form-control\" placeholder=\"Nom\" aria-describedby=\"helpId\">\r\n" + 
					"\r\n" + 
					"                      <label for=\"prenom\">Prenom :</label>\r\n" + 
					"                      <input type=\"text\" name=\"prenom\" id=\"prenom\" class=\"form-control\" placeholder=\"prenom\" aria-describedby=\"helpId\">\r\n" + 
					"\r\n" + 
					"                      <label for=\"CIN\">CIN :</label>\r\n" + 
					"                      <input type=\"text\" name=\"CIN\" id=\"CIN\" class=\"form-control\" placeholder=\"CIN\" aria-describedby=\"helpId\">\r\n" + 
					"\r\n" + 
					"                      <div class=\"text-right mt-2\">\r\n" + 
					"                        <button type=\"submit\" name=\"\" id=\"\" class=\"btn btn-success\">Add</button>\r\n" + 
					"                        <button type=\"reset\" name=\"\" id=\"\" class=\"btn btn-warning\">Reset</button>\r\n" + 
					"                      </div>\r\n" + 
					"                    </div>\r\n" + 
					"                </form>\r\n" + 
					"            </div>\r\n" + 
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

		}catch(Exception e) {
			out.println(e);
		}
	}

}
