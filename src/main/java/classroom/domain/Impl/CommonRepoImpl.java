package classroom.domain.Impl;

import classroom.dal.hibernate.*;
import classroom.dal.roots.*;
import classroom.domain.entities.*;
import org.hibernate.*;

import java.util.*;

public class CommonRepoImpl implements CommonRepo
{

	@Override
	public <T extends BaseEntity> T add(T entity)
	{
		Session commonRepo = HibernateDBManager.getCommonRepo();
		try
		{
			HibernateDBManager.beginTransaction();
			commonRepo.save(entity);
			HibernateDBManager.commitTransaction();
			return entity;
		}
		catch (Exception e)
		{
			e.printStackTrace();
			HibernateDBManager.rollbackTransaction();
			throw e;
		}
	}

	@Override
	public <T extends BaseEntity> T edit(T entity)
	{
		Session commonRepo = HibernateDBManager.getCommonRepo();
		try
		{
			HibernateDBManager.beginTransaction();
			commonRepo.saveOrUpdate(entity);
			HibernateDBManager.commitTransaction();
			return entity;
		}
		catch (Exception e)
		{
			e.printStackTrace();
			HibernateDBManager.rollbackTransaction();
			throw e;
		}
	}

	@Override
	public <T extends BaseEntity> void delete(T entity)
	{
		Session commonRepo = HibernateDBManager.getCommonRepo();
		try
		{
			HibernateDBManager.beginTransaction();
			commonRepo.delete(entity);
			HibernateDBManager.commitTransaction();
		}
		catch (Exception e)
		{
			e.printStackTrace();
			HibernateDBManager.rollbackTransaction();
			throw e;
		}
	}

	@Override
	public <T extends BaseEntity> T find(Class<T> klass, Long id)
	{
		Session commonRepo = HibernateDBManager.getCommonRepo();
		try
		{
			HibernateDBManager.beginTransaction();
			T foundEntity = (T) commonRepo.get(klass, id);
			HibernateDBManager.commitTransaction();
			return foundEntity;
		}
		catch (Exception e)
		{
			e.printStackTrace();
			HibernateDBManager.rollbackTransaction();
			throw e;
		}
	}

	@Override
	public <T extends BaseEntity> List<T> findAll(Class<T> klass)
	{
		Session commonRepo = HibernateDBManager.getCommonRepo();
		try
		{
			HibernateDBManager.beginTransaction();
			Criteria criteria = commonRepo.createCriteria(klass);
			List<T> listOfFoundRows = (List<T>) criteria.list();
			HibernateDBManager.commitTransaction();
			return listOfFoundRows;
		}
		catch (Exception e)
		{
			e.printStackTrace();
			HibernateDBManager.rollbackTransaction();
			throw e;
		}
	}
}
