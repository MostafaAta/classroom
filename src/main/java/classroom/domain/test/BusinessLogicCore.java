package classroom.domain.test;

import classroom.dal.entities.BaseEntity;
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
		String hibernateConfigFile = "hibernate.cfg.xml";
		HibernateDBManager.setDbConfigFileName(hibernateConfigFile);
		HibernateDBManager.buildSessionFactory();
	}

	public <T extends BaseEntity> T add(BaseEntity entity) throws Exception
	{
		return commonRepo.add(entity);
	}

	public <T extends BaseEntity> T edit(BaseEntity obj) throws Exception
	{
		return commonRepo.edit(obj);
	}

	public void delete(BaseEntity obj) throws Exception
	{
		commonRepo.delete(obj);
	}

	public <T extends BaseEntity> T find(BaseEntity obj, Long id) throws Exception
	{
		return commonRepo.find(obj, id);
	}

	public <T extends BaseEntity> List findAll(BaseEntity obj) throws Exception
	{
		return commonRepo.findAll(obj);
	}
}
