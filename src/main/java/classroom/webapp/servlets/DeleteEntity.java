package classroom.webapp.servlets;

import classroom.dal.roots.*;
import classroom.domain.test.*;
import classroom.util.*;

import javax.servlet.*;
import javax.servlet.annotation.*;
import javax.servlet.http.*;
import java.io.*;

@WebServlet(name = "DeleteEntity")
public class DeleteEntity extends HttpServlet
{
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException
	{

	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException
	{
		try
		{
			BusinessLogicCore<? extends BaseEntity> core = BusinessLogicCore.get();
			Class<? extends BaseEntity> klass = CommonUtil.calculateClassFrom(request.getParameter("class"));
			Long id = Long.parseLong(request.getParameter("id"));
			core.deleteById(klass, id);
		}
		catch (Throwable e)
		{
			//TODO : show faild message on page or success message
			e.printStackTrace();
		}
	}
}
