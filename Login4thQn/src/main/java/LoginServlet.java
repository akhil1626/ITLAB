

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;


public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			PrintWriter pw=response.getWriter();
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/login4thqn","root","Akhil@849984");
			String name=request.getParameter("name");
			String password=request.getParameter("password");
			
			
			PreparedStatement ps=con.prepareStatement("select name from login where name=? and password=?");
			ps.setString(1,name);
			ps.setString(2, password);
			ResultSet r=ps.executeQuery();
			if(r.next())
			{

				pw.println("Wellcome "+name);
			}
			else {
				pw.println("<a href=Login.jsp >badha padaku malli try cheyyi bro........!");
			}
			
			 
		} catch (ClassNotFoundException e) {
			
			e.printStackTrace();
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
	}

}
