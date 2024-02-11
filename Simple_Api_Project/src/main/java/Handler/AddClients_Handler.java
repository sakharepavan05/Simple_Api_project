package Handler;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import BO.AddClients_BO;
import DAO.Login_DAO;

/**
 * Servlet implementation class AddClients_Handler
 */
@WebServlet("/AddClients_Handler")
public class AddClients_Handler extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddClients_Handler() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter pw=response.getWriter();
		
		String Name=request.getParameter("name");
		String User_Id=request.getParameter("user");
		String Company=request.getParameter("company");
		String Email=request.getParameter("email");
		String Phone=request.getParameter("phone");
		
		AddClients_BO lb=new AddClients_BO(Name,User_Id,Company,Email,Phone);
		
		int status=Login_DAO.ClientEntity(lb);
		if(status >0)
		{
			pw.println("Client Add sucessfully");
			RequestDispatcher rd=request.getRequestDispatcher("Clients.html");
			rd.include(request, response);
		}
		else
		{
			pw.print("Client Add Try Again");
			RequestDispatcher rd=request.getRequestDispatcher("AddClients.html.html");
			rd.include(request, response);
		}
	}

}
