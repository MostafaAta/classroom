package classroom.domain.test;

import classroom.dal.hibernate.*;
import classroom.dal.roots.*;
import classroom.domain.Impl.*;
import classroom.domain.common.*;
import classroom.domain.entities.*;
import org.hibernate.criterion.*;

import java.util.*;

public class BusinessLogicCore<T extends Persistable>
{
	private CommonRepo<T> commonRepo;

	public static BusinessLogicCore<? extends BaseEntity> instance;

	public static BusinessLogicCore<? extends BaseEntity> get() throws Throwable
	{
		if (instance != null)
			return instance;
		return new BusinessLogicCore<>();
	}

	private BusinessLogicCore() throws Throwable
	{
		String hibernateConfigFile = "hibernate.cfg.xml";
		HibernateDBManager.setDbConfigFileName(hibernateConfigFile);
		HibernateDBManager.buildSessionFactory();
		commonRepo = new CommonRepoImpl<>();
	}

	public T add(T entity) throws Throwable
	{
		return commonRepo.add(entity);
	}

	public T edit(T obj) throws Throwable
	{
		return commonRepo.edit(obj);
	}

	public void delete(T entity) throws Throwable
	{
		commonRepo.delete(entity);
	}

	public void deleteById(Class<? extends Persistable> klass, Long id) throws Throwable
	{
		commonRepo.deleteById(klass, id);
	}

	public T find(Class<? extends Persistable> klass, Long id) throws Throwable
	{
		return commonRepo.find(klass, id);
	}

	public T find(String classType, Long id) throws Throwable
	{
		return commonRepo.find(classType, id);
	}

	public List<T> findAll(Class<? extends Persistable> klass) throws Throwable
	{
		return commonRepo.findAll(klass);
	}

	public List<T> findByCriteria(Class<? extends Persistable> klass, CriteriaBuilder... statments) throws Throwable
	{
		return commonRepo.findByCriteria(klass, statments);
	}

	public List<T> findByLike(Class<? extends Persistable> klass, MatchMode matchMode, CriteriaBuilder... statements) throws Throwable
	{
		return commonRepo.findByLike(klass, matchMode, statements);
	}
}
