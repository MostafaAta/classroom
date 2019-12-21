package classroom.webapp;

import classroom.dal.entities.*;
import classroom.dal.hibernate.*;
import classroom.domain.Impl.criteria.*;
import classroom.domain.test.*;
import org.hibernate.*;

import javax.servlet.*;
import javax.servlet.annotation.*;
import javax.servlet.http.*;
import java.io.*;
import java.util.*;

@WebServlet(name = "login")
public class Login extends HttpServlet
{
	private static final String ERROR_MESSAGE = "error";
	private static BusinessLogicCore core;

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		Map<String, String> map = validateClassroomUser(username, password);
		if (map.get(ERROR_MESSAGE) != null)
		{
			request.setAttribute("errorMessage", map.get(ERROR_MESSAGE));
			request.getRequestDispatcher("/login.jsp").forward(request, response);
			return;
		}
		request.setAttribute("username", username);
		request.setAttribute("password", password);
		request.getRequestDispatcher("/welcome.jsp").forward(request, response);
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{
	}

	private Map<String, String> validateClassroomUser(String username, String password)
	{
		Map<String, String> map = new HashMap<>();
		try
		{
			HibernateDBManager.setDbConfigFileName("hibernate.cfg.xml");
			HibernateDBManager.buildSessionFactory();
			Session commonRepo = HibernateDBManager.getCommonRepo();
			HibernateDBManager.beginTransaction();
			Criteria criteria = commonRepo.createCriteria(ClassroomUser.class);
			CriteriaBuilder name1 = CriteriaBuilder.createInstanceFor("name1", CriteriaStatementUtility.EQUAL, username);
			CriteriaBuilder password1 = CriteriaBuilder.createInstanceFor("password", CriteriaStatementUtility.EQUAL, password);
			CriteriaStatementUtility.addRestrictionsToCriteriaFrom(Arrays.asList(name1, password1), criteria);
			List user = criteria.list();
			if (user == null || user.isEmpty())
			{
				map.put(ERROR_MESSAGE, "Inavlid username and password, try again");
				return map;
			}
			for (Object o : user)
				System.out.println(((ClassroomUser) o).getName1() + " : " + ((ClassroomUser) o).getName2());
			return map;

			//			core = new BusinessLogicCore<>();
			//			Persistable foundUser = core.find(User.class, Long.valueOf(1));
			//			foundUser.toString();
		}
		catch (Throwable e)
		{
			e.printStackTrace();
			map.put(ERROR_MESSAGE, Arrays.toString(e.getStackTrace()));
			return map;
		}
	}
}
