package main;

import hibernate.HibernateDBManager;

public class TestMain
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
