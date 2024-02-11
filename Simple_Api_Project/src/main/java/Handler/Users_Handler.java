package Handler;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import BO.Login_BO;
import DAO.Login_DAO;
/**
 * Servlet implementation class Users_Handler
 */
@WebServlet("/Users_Handler")
public class Users_Handler extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Users_Handler() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter pw=response.getWriter();
		
		pw.println("<h1><a href='Index.html'>Back To Home Page</a></h1>");
		pw.println("<h1>Users List</h1>");
		List<Login_BO> list=Login_DAO.getAllUsers();
		pw.print("<table border='1' width='100%'");
		pw.print("<tr><th>Id</th><th>UserName</th><th>Password</th><th>created_at</th></tr>");
		for(Login_BO e:list)
		{
			pw.print("<tr><td>"+e.getKey()+"</td><td>"+e.getID()+"</td><td>"+e.getPassword()+"</td> <td>"+e.getDate()+"</td></tr>");

		}
		pw.print("</table>");
		
        pw.close();
	}

}
