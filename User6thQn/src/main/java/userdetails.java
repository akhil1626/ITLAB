

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;


@WebServlet("/userdetails")
public class userdetails extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
   

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter pw=response.getWriter();
		String id=request.getParameter("usrnm");
		try
		{
			Class.forName("com.mysql.jdbc.Driver");
			Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/user6thqn","root","Akhil@849984");
			String s="select * from  Register where user_name=?";
			PreparedStatement p=con.prepareStatement(s);
			p.setString(1, id);
			ResultSet r=p.executeQuery();
			boolean status=r.next();
			String userid=r.getString("user_name");
			if(status)
			{
				if(id.equals(userid))
				{
					String name=r.getString("name");
					String email=r.getString("email");
					String usrid=r.getString("user_name");
					//String pwd=r.getString("name");
					String phno=r.getString("phone_num");
					String addr=r.getString("address");
					
					pw.println("<center>");
					pw.println("<h3> Name : "+ name +"</h3><br>");
					pw.println("<h3> Email : "+ email +"</h3><br>");
					pw.println("<h3> User Name : "+ usrid +"</h3><br>");
					pw.println("<h3> Phone Number : "+ phno +"</h3><br>");
					pw.println("<h3> Address : "+ addr +"</h3><br>");
					pw.println("</center>");
				}
			}	
		}
		catch (Exception e)
		{
			pw.println("Your ID is  wrong please try again");
			pw.println("<a href='userlogin.html'>RETRY</a>");
		}
	}

}