package classroom.webapp.servlets;

import classroom.dal.roots.*;
import classroom.domain.test.*;

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
			Class<? extends BaseEntity> klass = ListViewServlet.calculateClassFrom(className);
			BusinessLogicCore<? extends BaseEntity> core = BusinessLogicCore.get();
			if (idStr != null)
				entity = core.find(klass, Long.parseLong(idStr));
			if (entity == null)
				entity = klass.newInstance();
			request.setAttribute("entity", entity);

			//TODO : switch to edit page
		}
		catch (Throwable e)
		{
			e.printStackTrace();
		}
	}
}
