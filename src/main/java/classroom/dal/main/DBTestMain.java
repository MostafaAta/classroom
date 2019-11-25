package classroom.dal.main;

import classroom.dal.hibernate.HibernateDBManager;

public class DBTestMain
{
	public static void main(String[] args)
	{
		try
		{
			String fileName = "hibernate.cfg.xml";
			HibernateDBManager.setDbConfigFileName(fileName);
			HibernateDBManager.buildSessionFactory();
		}
		catch (Exception e)
		{
			e.printStackTrace();
			System.out.println(e.getMessage());
		}
	}
}
