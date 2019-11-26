package classroom.domain.test;

import classroom.dal.entities.BaseEntity;
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
			//			addStudent();
			editStudent();

		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
	}

	private static void editStudent()
	{
		try
		{
			BusinessLogicCore blCore = new BusinessLogicCore();
			Student student = new Student();
			Student foundEntity = blCore.find(student, (long) 1);
			foundEntity.setEmail("ahmed@yahoo.com");
			BaseEntity editStudent = blCore.edit(foundEntity);
			showEntityResult(editStudent, "Edit");
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
	}

	private static void showEntityResult(BaseEntity entity, String type)
	{
		System.out.println(type + "   >>     id : " + entity.getId());
	}

	private static void addStudent()
	{
		try
		{
			BusinessLogicCore blCore = new BusinessLogicCore();
			Student student = new Student();
			student.setEmail("ahmed.atta@gmail");
			student.setGender(Gender.Male);
			student.setGpa(new BigDecimal(3.0));
			CompositeName name = new CompositeName();
			name.setFirstName("Ahmed");
			name.setLastName("Ali");
			student.setName(name);
			BaseEntity addedStudent = blCore.add(student);
			showEntityResult(addedStudent, " Add Entity");
		}
		catch (Exception e)
		{
			e.printStackTrace();
			HibernateDBManager.rollbackTransaction();
		}
	}
}
