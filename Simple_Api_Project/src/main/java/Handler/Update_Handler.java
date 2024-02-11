package Handler;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import BO.AddClients_BO;
import DAO.Login_DAO;


/**
 * Servlet implementation class Update_Handler
 */
@WebServlet("/Update_Handler")
public class Update_Handler extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Update_Handler() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter pw=response.getWriter();
		pw.println("<h1>Update Clients</h1>");
		String id=request.getParameter("id");
		AddClients_BO e=Login_DAO.getEmployeeById(id);
		pw.print("<form action='Update_Handler1' method='post'>");
		pw.print("<table>");
		pw.print("<tr><td></td><td><input type='hidden' name='id' value='"+e.getId()+"'/></td></tr>");
		pw.print("<tr><td>Name:</td><td><input type='text' name='name' value='"+e.getName()+"'/></td></tr>");
		pw.print("<tr><td>User_Id:</td><td><input type='text' name='user' value='"+e.getUser_ID()+"'/></td></tr>");				
		pw.print("<tr><td>company:</td><td>");
		pw.print("<select name='company' style='width:150px'>");
		pw.print("<option value='google'>Google</option>");
		pw.print("<option value='Infosys'>Infosys</option>");		
		pw.print("</select>");
		pw.print("</td></tr>");
		pw.print("<tr><td>Email:</td><td><input type='email' name='email'value='"+e.getEmail()+"'/></td></tr>");
		pw.print("<tr><td>Phone:</td><td><input type='tel' name='phone' value='"+e.getPhone()+"'/></td></tr>");
		pw.print("<tr><td colspan='2'><input type='submit' value='Edit & Save '/></td></tr>");
		pw.print("</table>");
		pw.print("</form>");
      
		pw.close();
	}

}
