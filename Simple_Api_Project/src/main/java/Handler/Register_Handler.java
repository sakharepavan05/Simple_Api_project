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
 * Servlet implementation class Register_Handler
 */
@WebServlet("/Register_Handler")
public class Register_Handler extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Register_Handler() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter pw=response.getWriter();
		
		String user=request.getParameter("user");
		String password=request.getParameter("password");
		Login_BO lb=new Login_BO(user,password);
		
		int status=Login_DAO.insert(lb);
		if(status >0)
		{
			pw.println("Register sucessfully");
			RequestDispatcher rd=request.getRequestDispatcher("Login.html");
			rd.include(request, response);
		}
		else
		{
			pw.print("Register Try Again");
			RequestDispatcher rd=request.getRequestDispatcher("Register.html");
			rd.include(request, response);
		}
	}

}
