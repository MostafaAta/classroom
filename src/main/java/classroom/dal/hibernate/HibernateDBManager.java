package classroom.dal.hibernate;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;

public class HibernateDBManager
{
	private static SessionFactory sessionFactory;
	private static String dbConfigFileName;

	public static void setDbConfigFileName(String dbConfigFileName)
	{
		HibernateDBManager.dbConfigFileName = dbConfigFileName;
	}

	public static SessionFactory getSessionFactory()
	{
		return sessionFactory;
	}

	public static void buildSessionFactory() throws Exception
	{
		try
		{
			if (sessionFactory != null)
				return;
			if (dbConfigFileName == null)
				throw new Exception("Error: you must call setDbConfigFileName");
			Configuration configuration = new Configuration().configure(dbConfigFileName);
			StandardServiceRegistryBuilder serviceRegistryBuilder = new StandardServiceRegistryBuilder();
			serviceRegistryBuilder.applySettings(configuration.getProperties());
			StandardServiceRegistry serviceRegistry = serviceRegistryBuilder.build();
			sessionFactory = configuration.buildSessionFactory(serviceRegistry);
		}
		catch (HibernateException e)
		{
			sessionFactory = null;
			dbConfigFileName = null;
			throw e;
		}
	}

	public static Session getCommonRepo()
	{
		return sessionFactory.getCurrentSession();
	}

	public static void beginTransaction()
	{
		sessionFactory.getCurrentSession().beginTransaction();
	}

	public static void commitTransaction()
	{
		sessionFactory.getCurrentSession().getTransaction().commit();
	}

	public static void rollbackTransaction()
	{
		if (sessionFactory.getCurrentSession().getTransaction().isActive())
			sessionFactory.getCurrentSession().getTransaction().rollback();
	}
}
