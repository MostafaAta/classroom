package classroom.webapp.servlets;

import classroom.dal.roots.*;
import classroom.domain.common.*;
import classroom.domain.test.*;
import classroom.util.*;

import javax.servlet.*;
import javax.servlet.annotation.*;
import javax.servlet.http.*;
import java.io.*;
import java.util.*;

import static classroom.webapp.servlets.EditEntity.*;

@WebServlet(name = "add")
public class AddEntity extends HttpServlet
{
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{

	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{
		try
		{
			BaseEntity entity = null;
			saveEntity(entity, request, response);
		}
		catch (Throwable e)
		{
			e.printStackTrace();
		}
	}

	private <T extends BaseEntity> void saveEntity(T entity, HttpServletRequest request, HttpServletResponse response)
	{
		String idStr = (String) request.getSession().getAttribute("idStr");
		String className = (String) request.getSession().getAttribute("class");
		Class<? extends BaseEntity> klass = CommonUtil.calculateClassFrom(className);
		BusinessLogicCore<T> core = null;
		try
		{
			core = (BusinessLogicCore<T>) BusinessLogicCore.get();
			Long id = parseId(idStr);
			if (id != null)
				entity = (T) core.find(klass, id);
			if (entity == null)
				entity = (T) klass.newInstance();
			List<String> fieldNames = (List<String>) request.getSession().getAttribute("fieldNames");
			List<String> fieldValues = Arrays.asList(request.getParameterValues("fieldValue"));
			for (int i = 0; i < fieldNames.size(); i++)
				updateHeaderData(entity, new FieldMetaData(fieldNames.get(i).trim(), fieldValues.get(i).trim()));
			BaseEntity savedEntity = null;
			if (id != null)
				savedEntity = core.edit(entity);
			else
				savedEntity = core.add(entity);
			if (savedEntity != null)
				System.out.println(savedEntity.getId());
			if (savedEntity != null)
				request.getSession().setAttribute("success", savedEntity.getId());
			response.sendRedirect("listView?class=" + className);
		}
		catch (Throwable e)
		{
			System.out.println(e.getMessage());
			e.printStackTrace();
		}
	}

	private void updateHeaderData(BaseEntity entity, FieldMetaData metaData)
	{
		switch (metaData.getFieldName())
		{
		case "ID":
			entity.setId(Long.parseLong((String) metaData.getValue()));
			break;
		case "Code":
			entity.setCode((String) metaData.getValue());
			break;
		case "Name1":
			entity.setName1((String) metaData.getValue());
			break;
		case "Name2":
			entity.setName2((String) metaData.getValue());
			break;
		}
	}
}
