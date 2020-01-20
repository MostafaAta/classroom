package classroom.webapp.servlets;

import classroom.dal.entities.*;
import classroom.dal.roots.*;
import classroom.domain.test.*;

import javax.servlet.*;
import javax.servlet.annotation.*;
import javax.servlet.http.*;
import java.io.*;
import java.util.*;

@WebServlet(name = "list_view_servlet")
public class ListViewServlet extends HttpServlet
{
	private Class<? extends BaseEntity> entityClass;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{
		entityClass = calculateClassFrom(request.getParameter("class"));
		request.setAttribute("list", listEntities());
		request.setAttribute("class", entityClass);
		request.setAttribute("class_name", entityClass.getSimpleName());
		request.getRequestDispatcher("/home.jsp").forward(request, response);
	}

	public static Class<? extends BaseEntity> calculateClassFrom(String className)
	{
		className = className == null ? "Course" : className;
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

	private List<? extends BaseEntity> listEntities() throws ServletException
	{
		if (entityClass == null)
			throw new ServletException("Entity Class is null");
		try
		{
			BusinessLogicCore<? extends BaseEntity> core = BusinessLogicCore.get();
			return core.findAll(entityClass);
		}
		catch (Throwable e)
		{
			e.printStackTrace();
			throw new ServletException(e);
		}
	}
}
