package classroom.domain.test;

import classroom.dal.entities.Embeddable.CompositeName;
import classroom.dal.entities.Student;
import classroom.dal.hibernate.HibernateDBManager;
import classroom.dal.primitives.Gender;

import java.math.BigDecimal;

public class DomainTestMain
{
	public static void main(String[] args)
	{
		try
		{
			String hibernateConfigFile = "hibernate.cfg.xml";
			HibernateDBManager.setDbConfigFileName(hibernateConfigFile);
			HibernateDBManager.buildSessionFactory();
			BusinessLogicCore blCore = new BusinessLogicCore();
			Student student = addStudent();
			blCore.add(student);
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
	}

	private static Student addStudent()
	{
		Student student = new Student();
		student.setEmail("mostafa.atta@gmail");
		student.setGender(Gender.Male);
		student.setGpa(new BigDecimal(2.8));
		CompositeName name = new CompositeName();
		name.setFirstName("Mostafa");
		name.setLastName("Atta");
		student.setName(name);
		return student;
	}
}
