package classroom.webapp.servlets;

import classroom.dal.entities.*;
import classroom.dal.roots.*;

import javax.servlet.*;
import javax.servlet.annotation.*;
import javax.servlet.http.*;
import java.io.*;

@WebServlet(name = "switcher")
public class Switcher extends HttpServlet
{
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{
		switchToHomePage(request, response);
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{
		switchToHomePage(request, response);
	}

	private void switchToHomePage(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{
		request.setAttribute("class", calculateClassFrom(request.getParameter("class")));
		request.getRequestDispatcher("/home.jsp").forward(request, response);
	}

	private Class<? extends BaseEntity> calculateClassFrom(String className)
	{
		switch (className)
		{
		case "Student":
			return Student.class;
		case "Course":
			return Course.class;
		case "Instructor":
			return Instructor.class;
		case "CourseLike":
			return CourseLike.class;
		case "CourseRegistration":
			return CourseRegistration.class;
		case "CourseRating":
			return CourseRating.class;
		}
		return null;
	}
}
