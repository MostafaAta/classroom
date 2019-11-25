package classroom.domain.test;

import classroom.dal.hibernate.HibernateDBManager;
import classroom.domain.Impl.CommonRepoImpl;
import classroom.domain.entities.CommonRepo;

import java.util.List;

public class BusinessLogicCore
{
	private CommonRepo commonRepo;

	public BusinessLogicCore() throws Exception
	{
		commonRepo = new CommonRepoImpl();
		HibernateDBManager.buildSessionFactory();
	}

	public <T> T add(T obj) throws Exception
	{
		return commonRepo.add(obj);
	}

	public <T> T edit(T obj) throws Exception
	{
		return commonRepo.edit(obj);
	}

	public <T> void delete(T obj) throws Exception
	{
		commonRepo.delete(obj);
	}

	public <T> T find(T obj) throws Exception
	{
		return commonRepo.find(obj);
	}

	public <T> List<T> findAll(T obj) throws Exception
	{
		return commonRepo.findAll(obj);
	}
}
