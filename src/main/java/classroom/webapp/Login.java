package classroom.webapp;

import classroom.dal.entities.*;
import classroom.dal.hibernate.*;
import classroom.domain.test.*;
import org.hibernate.*;
import org.hibernate.criterion.*;

import javax.servlet.*;
import javax.servlet.annotation.*;
import javax.servlet.http.*;
import java.io.*;
import java.util.*;

@WebServlet(name = "login")
public class Login extends HttpServlet
{
	private static BusinessLogicCore core;

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		if (validateUser(username, password))
			request.getRequestDispatcher("/welcome.jsp").forward(request, response);
		else
		{
			request.setAttribute("errorMessage", "Invaild login username and password , Try again");
			request.getRequestDispatcher("/login.jsp").forward(request, response);
		}
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{
	}

	private Boolean validateUser(String username, String password)
	{
		try
		{
			HibernateDBManager.setDbConfigFileName("hibernate.cfg.xml");
			HibernateDBManager.buildSessionFactory();
			Session commonRepo = HibernateDBManager.getCommonRepo();
			HibernateDBManager.beginTransaction();
			Criteria criteria = commonRepo.createCriteria(User.class);
			criteria.add(Restrictions.gt("name1", username));
			criteria.add(Restrictions.gt("name2", password));
			List user = criteria.list();
			for (Object o : user)
				System.out.println(((User) o).getName1() + " : " + ((User) o).getName2());
			HibernateDBManager.commitTransaction();
			if (user != null)
				return true;

			//			core = new BusinessLogicCore<>();
			//			Persistable foundUser = core.find(User.class, Long.valueOf(1));
			//			foundUser.toString();
		}
		catch (Throwable e)
		{
			e.printStackTrace();
		}
		return false;
	}
}
