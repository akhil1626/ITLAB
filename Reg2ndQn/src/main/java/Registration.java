

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;


@WebServlet("/Registration")
public class Registration extends HttpServlet {
	private static final long serialVersionUID = 1L;
    public Registration() {
        super();
       
    }

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		
		PrintWriter pw=response.getWriter();
		String name=request.getParameter("name");
		String email=request.getParameter("email");
		String uname =request.getParameter("usrnm");
		String pwd=request.getParameter("pwd");
		String phno=request.getParameter("phno");
		String addr=request.getParameter("address");
		
		pw.print("<html><head><title>Storing into database</title></head><body style='text-align:center;'>");
		
		try
		{
			Class.forName("com.mysql.jdbc.Driver");
			Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/reg2ndqn","root","Akhil@849984");
			String s="insert into register values(?,?,?,?,?,?)";
			PreparedStatement p=con.prepareStatement(s);
			p.setString(1, name);
			p.setString(2, email);
			p.setString(3, uname);
			p.setString(4, pwd);
			p.setString(5, phno);
			p.setString(6, addr);
			int i=p.executeUpdate();
			if(i>0)
			{
				pw.println("<h1>Congrtas you registered successfully</h1>");
			}
			else
			{
				pw.println("<h1> Something wrong happened please try agin </h1>");
			}
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
		pw.print("</body></html>");
	}

}