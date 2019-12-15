package classroom.servlets;

import javax.servlet.*;
import javax.servlet.annotation.*;
import javax.servlet.http.*;
import java.io.*;

@WebServlet(name = "Login" , urlPatterns = {"/login"})
public class Login extends HttpServlet
{
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{

	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{
		response.setContentType("Mostafa Atta");
		PrintWriter out = response.getWriter();
		out.println("<h1>Test Servlet from Source Code </h1>");
		out.flush();
	}
}
