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
		student.setEmail("ahmed.atta@gmail");
		student.setGender(Gender.Male);
		student.setGpa(new BigDecimal(3.0));
		CompositeName name = new CompositeName();
		name.setFirstName("Ahmed");
		name.setLastName("Ali");
		student.setName(name);
		return student;
	}
}
