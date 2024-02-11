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
 * Servlet implementation class Update_Handler1
 */
@WebServlet("/Update_Handler1")
public class Update_Handler1 extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Update_Handler1() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter pw=response.getWriter();
		pw.println("<h1>Updat Clients</h1>");
		String ID=request.getParameter("id");
		String Name=request.getParameter("name");
		String User_Id=request.getParameter("user");
		String Company=request.getParameter("company");
		String Email=request.getParameter("email");
		String Phone=request.getParameter("phone");
		AddClients_BO e=new AddClients_BO();
		 e.setId(ID);
	     e.setName(Name);
		 e.setUser_ID(User_Id);
		 e.setCompany(Company);
		 e.setEmail(Email);
		 e.setPhone(Phone);
		int status=Login_DAO.update(e);
		if(status >0)
		{
			response.sendRedirect("ClientsUser_Handler");
		}
		else
		{
			pw.println("Sorry! unable to update record\"");
		}
	}

}
