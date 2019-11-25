package classroom.domain.test;

import classroom.dal.hibernate.HibernateDBManager;
import classroom.domain.Impl.CommonRepo;
import classroom.domain.entities.ClassroomDelegator;

public class BusinessLogicCore
{
	// our delegator to DAL Layer (Database)
	private ClassroomDelegator delegator;

	public BusinessLogicCore() throws Exception
	{
		delegator = new CommonRepo();
		HibernateDBManager.buildSessionFactory();
	}
}
