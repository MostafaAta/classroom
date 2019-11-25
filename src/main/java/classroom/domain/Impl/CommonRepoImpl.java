package classroom.domain.Impl;

import classroom.dal.hibernate.HibernateDBManager;
import classroom.domain.entities.CommonRepo;
import org.hibernate.Session;

import java.util.List;

public class CommonRepoImpl implements CommonRepo
{

	@Override
	public <T> T add(T obj)
	{
		Session commonRepo = HibernateDBManager.getCommonRepo();
		try
		{
			HibernateDBManager.beginTransaction();
			commonRepo.saveOrUpdate(obj);
			HibernateDBManager.commitTransaction();
			return obj;
		}
		catch (Exception e)
		{
			e.printStackTrace();
			HibernateDBManager.rollbackTransaction();
			throw e;
		}
	}

	@Override
	public <T> T edit(T obj)
	{
		return null;
	}

	@Override
	public <T> void delete(T obj)
	{

	}

	@Override
	public <T> T find(T obj)
	{
		return null;
	}

	@Override
	public <T> List<T> findAll(T obj)
	{
		return null;
	}
}
