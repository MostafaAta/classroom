package classroom.domain.test;

import classroom.dal.hibernate.HibernateDBManager;
import classroom.domain.Impl.EnrollModuleImpl;
import classroom.domain.entities.EnrollModule;

import java.util.List;

public class BusinessLogicCore
{
	private EnrollModule enrollModule;

	public BusinessLogicCore() throws Exception
	{
		enrollModule = new EnrollModuleImpl();
		HibernateDBManager.buildSessionFactory();
	}

	public <T> T add(Class<T> obj) throws Exception
	{
		return enrollModule.add(obj);
	}

	public <T> T edit(Class<T> obj) throws Exception
	{
		return enrollModule.edit(obj);
	}

	public <T> void delete(Class<T> obj) throws Exception
	{
		enrollModule.delete(obj);
	}

	public <T> T find(Class<T> obj) throws Exception
	{
		return enrollModule.find(obj);
	}

	public <T> List<T> findAll(Class<T> obj) throws Exception
	{
		return enrollModule.findAll(obj);
	}
}
