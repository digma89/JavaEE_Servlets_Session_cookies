

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class LoginServlet
 */
@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	String userID = "centennial";
	String password = "12345";
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String user = request.getParameter("username");
		String pass = request.getParameter("password");
		if(userID.equals(user) && password.equals(pass)){
		Cookie cookie = new Cookie("user",user);
		cookie.setMaxAge(30*60);
		response.addCookie(cookie);
		response.sendRedirect("DirectServlet");
		}
		
		else
		{
		RequestDispatcher rd = getServletContext().getRequestDispatcher("/Login.html");
		PrintWriter out= response.getWriter();
		out.println("Invalid user name or password");
		rd.include(request, response);
		}
	}

}
