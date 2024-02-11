package Handler;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import BO.AddClients_BO;
import DAO.Login_DAO;

/**
 * Servlet implementation class ClientsUser_Handler
 */
@WebServlet("/ClientsUser_Handler")
public class ClientsUser_Handler extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ClientsUser_Handler() {
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
		List<AddClients_BO> list=Login_DAO.getAllClientUsers();
		pw.print("<table border='1' width='100%'");
		pw.print("<tr><th>Id</th><th>Name</th><th>User</th><th>Company</th><th>Email</th><th>Phone</th><th>CreatedAt</th><th>UpdatedAt</th><th>DeletedAt</th><th>Active</th><th>Update</th><th>Delete</th></tr>");
		for(AddClients_BO e:list)
		{
			pw.print("<tr><td>"+e.getId()+"</td><td>"+e.getName()+"</td><td>"+e.getUser_ID()+"</td><td>"+e.getCompany()+"</td><td>"+e.getEmail()+"</td><td>"+e.getPhone()+"</td><td>"+e.getCreatedAt()+"</td> <td>"+e.getUpdatedAt()+"</td><td>"+e.getDeletedAt()+"</td><td>"+e.getActive()+"</td><td><a href='Update_Handler?id="+e.getId()+"'>Update</a></td><td><a href='Delete_Handler?id="+e.getId()+"'>delete</a></td></tr>");

		}
		pw.print("</table>");
		
        pw.close();
	}

}
