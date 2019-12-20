package classroom.webapp;

import classroom.dal.entities.ClassroomUser;
import classroom.dal.hibernate.HibernateDBManager;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "login")
public class Login extends HttpServlet
{
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		if (validateClassroomUser(username, password))
		{
			request.setAttribute("username", username);
			request.setAttribute("password", password);
			request.getRequestDispatcher("/welcome.jsp").forward(request, response);
		}
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
			if (user.size() == 0)
				return false;
		}
		catch (Throwable e)
		{
			e.printStackTrace();
		}
		return true;
	}
}
