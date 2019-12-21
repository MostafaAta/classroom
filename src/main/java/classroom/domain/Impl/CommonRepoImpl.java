package classroom.domain.Impl;

import classroom.dal.details.*;
import classroom.dal.entities.*;
import classroom.dal.hibernate.*;
import classroom.dal.roots.*;
import classroom.domain.common.*;
import classroom.domain.entities.*;
import org.hibernate.*;

import java.util.*;

public class CommonRepoImpl<T extends Persistable> implements CommonRepo<T>
{

	@Override
	public T add(T entity)
	{
		Session commonRepo = HibernateDBManager.getCommonRepo();
		try
		{
			HibernateDBManager.beginTransaction();
			commonRepo.save(entity);
			HibernateDBManager.commitTransaction();
			return entity;
		}
		catch (Throwable e)
		{
			e.printStackTrace();
			HibernateDBManager.rollbackTransaction();
			throw e;
		}
	}

	@Override
	public T edit(T entity)
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
	public void delete(T entity)
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

	@SuppressWarnings("unchecked")
	@Override
	public T find(Class<? extends Persistable> klass, Long id)
	{
		if (klass == null)
			return null;
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
	public T find(String classType, Long id)
	{
		return find(calculateClassFromType(classType), id);
	}

	@SuppressWarnings("unchecked")
	private static Class<? extends Persistable> calculateClassFromType(String classType)
	{
		if (classType.equals(Student.class.getSimpleName()))
			return Student.class;
		if (classType.equals(Course.class.getSimpleName()))
			return Course.class;
		if (classType.equals(Instructor.class.getSimpleName()))
			return Instructor.class;
		if (classType.equals(CourseLike.class.getSimpleName()))
			return CourseLike.class;
		if (classType.equals(CourseRating.class.getSimpleName()))
			return CourseRating.class;
		if (classType.equals(ClassroomUser.class.getSimpleName()))
			return ClassroomUser.class;
		if (classType.equals(CourseRatingLine.class.getSimpleName()))
			return CourseRatingLine.class;
		if (classType.equals(CourseLikeLine.class.getSimpleName()))
			return CourseLikeLine.class;
		return null;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<T> findAll(Class<? extends Persistable> klass)
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

	@Override
	public List<T> findByCriteria(Class<? extends Persistable> klass, CriteriaBuilder... statments)
	{
		Session commonRepo = HibernateDBManager.getCommonRepo();
		try
		{
			HibernateDBManager.beginTransaction();
			Criteria criteria = commonRepo.createCriteria(klass);
			CriteriaStatementUtility.addRestrictionsToCriteriaFrom(Arrays.asList(statments), criteria);
			List entity = criteria.list();
			HibernateDBManager.commitTransaction();
			if (entity != null && !entity.isEmpty())
				return (List<T>) entity;
		}
		catch (Exception e)
		{
			e.printStackTrace();
			HibernateDBManager.rollbackTransaction();
		}
		return null;
	}
}
