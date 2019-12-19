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
		if (validateClassroomUser(username, password))
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

	private Boolean validateClassroomUser(String username, String password)
	{
		try
		{
			HibernateDBManager.setDbConfigFileName("hibernate.cfg.xml");
			HibernateDBManager.buildSessionFactory();
			Session commonRepo = HibernateDBManager.getCommonRepo();
			HibernateDBManager.beginTransaction();
			Criteria criteria = commonRepo.createCriteria(ClassroomUser.class);
			criteria.add(Restrictions.eq("name1", username));
			criteria.add(Restrictions.eq("password", password));
			List user = criteria.list();
			if (user == null)
				return false;
			for (Object o : user)
				System.out.println(((ClassroomUser) o).getName1() + " : " + ((ClassroomUser) o).getName2());
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
