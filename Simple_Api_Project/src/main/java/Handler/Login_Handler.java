package Handler;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import BO.Login_BO;
import DAO.Login_DAO;


/**
 * Servlet implementation class Login_Handler
 */
@WebServlet("/Login_Handler")
public class Login_Handler extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * Default constructor. 
     */
    public Login_Handler() {
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter pw=response.getWriter();
		String ID=request.getParameter("user");
		String Password=request.getParameter("password");
	//	pw.print(id+"\t"+pass);
	
		Login_BO lb=new Login_BO(ID,Password);
		
		if(Login_DAO.Api_login(lb))
		{
			RequestDispatcher rd=request.getRequestDispatcher("Index.html");
			rd.include(request, response);
		}
		else
		{
			pw.print("Enter Correct User And Password");
			RequestDispatcher rd=request.getRequestDispatcher("login.html");
			rd.include(request, response);
		}
		
		
	}

}
