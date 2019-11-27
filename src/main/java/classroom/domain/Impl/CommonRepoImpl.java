package classroom.domain.Impl;

import classroom.dal.entities.BaseEntity;
import classroom.dal.hibernate.HibernateDBManager;
import classroom.domain.entities.CommonRepo;
import org.hibernate.Criteria;
import org.hibernate.Session;

import java.util.List;

public class CommonRepoImpl implements CommonRepo
{

	@Override
	public <T extends BaseEntity> T add(BaseEntity entity)
	{
		Session commonRepo = HibernateDBManager.getCommonRepo();
		try
		{
			HibernateDBManager.beginTransaction();
			commonRepo.save(entity);
			HibernateDBManager.commitTransaction();
			return (T) entity;
		}
		catch (Exception e)
		{
			e.printStackTrace();
			HibernateDBManager.rollbackTransaction();
			throw e;
		}
	}

	@Override
	public <T extends BaseEntity> T edit(BaseEntity entity)
	{
		Session commonRepo = HibernateDBManager.getCommonRepo();
		try
		{
			HibernateDBManager.beginTransaction();
			commonRepo.saveOrUpdate(entity);
			HibernateDBManager.commitTransaction();
			return (T) entity;
		}
		catch (Exception e)
		{
			e.printStackTrace();
			HibernateDBManager.rollbackTransaction();
			throw e;
		}
	}

	@Override
	public <T extends BaseEntity> void delete(Long id)
	{
		Session commonRepo = HibernateDBManager.getCommonRepo();
		try
		{
			HibernateDBManager.beginTransaction();
			commonRepo.delete(id);
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
			BaseEntity foundEntity = (BaseEntity) commonRepo.get(klass, id);
			HibernateDBManager.commitTransaction();
			return (T) foundEntity;
		}
		catch (Exception e)
		{
			e.printStackTrace();
			HibernateDBManager.rollbackTransaction();
			throw e;
		}
	}

	@Override
	public <T extends BaseEntity> List findAll(BaseEntity entity)
	{
		Session commonRepo = HibernateDBManager.getCommonRepo();
		try
		{
			HibernateDBManager.beginTransaction();
			Criteria criteria = commonRepo.createCriteria(entity.getClass());
			List listOfFoundRows = criteria.list();
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
