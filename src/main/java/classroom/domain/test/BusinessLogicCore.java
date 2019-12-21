package classroom.domain.test;

import classroom.dal.hibernate.*;
import classroom.dal.roots.*;
import classroom.domain.Impl.*;
import classroom.domain.common.*;
import classroom.domain.entities.*;

import java.util.*;

public class BusinessLogicCore<T extends Persistable>
{
	private CommonRepo<T> commonRepo;

	public BusinessLogicCore() throws Throwable
	{
		commonRepo = new CommonRepoImpl<>();
		String hibernateConfigFile = "hibernate.cfg.xml";
		HibernateDBManager.setDbConfigFileName(hibernateConfigFile);
		HibernateDBManager.buildSessionFactory();
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
}
