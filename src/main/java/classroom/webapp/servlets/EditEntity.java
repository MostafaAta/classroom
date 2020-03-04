package classroom.webapp.servlets;

import classroom.dal.roots.*;
import classroom.domain.test.*;
import classroom.util.*;

import javax.servlet.*;
import javax.servlet.annotation.*;
import javax.servlet.http.*;
import java.io.*;

@WebServlet(name = "edit")
public class EditEntity extends HttpServlet
{
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{

	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{
		try
		{
			String idStr = request.getParameter("idStr");
			String className = request.getParameter("class");
			BaseEntity entity = null;
			Class<? extends BaseEntity> klass = CommonUtil.calculateClassFrom(className);
			BusinessLogicCore<? extends BaseEntity> core = BusinessLogicCore.get();
			Long id = parseId(idStr);
			if (id != null)
				entity = core.find(klass, id);
			if (entity == null)
				entity = klass.newInstance();
			request.setAttribute("entity", entity);
			request.setAttribute("class_name", entity.getClass().getSimpleName());
			request.getRequestDispatcher("edit.jsp").forward(request, response);
		}
		catch (Throwable e)
		{
			e.printStackTrace();
		}
	}

	public static Long parseId(String idStr)
	{
		try
		{
			return Long.parseLong(idStr);
		}
		catch (Throwable e)
		{
			return null;
		}
	}
}
