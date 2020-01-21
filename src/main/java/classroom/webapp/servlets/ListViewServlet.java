package classroom.webapp.servlets;

import classroom.dal.roots.*;
import classroom.domain.test.*;
import classroom.util.*;

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
		entityClass = CommonUtil.calculateClassFrom(request.getParameter("class"));
		request.setAttribute("list", listEntities());
		request.setAttribute("class", entityClass);
		request.setAttribute("class_name", entityClass.getSimpleName());
		request.getRequestDispatcher("home.jsp").forward(request, response);
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
