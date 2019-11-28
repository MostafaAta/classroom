package classroom.domain.test;

import classroom.dal.entities.*;
import classroom.dal.entities.Embeddable.CompositeName;
import classroom.dal.hibernate.HibernateDBManager;
import classroom.dal.primitives.Gender;

import java.math.BigDecimal;

public class DomainTestMain
{
	public static void main(String[] args)
	{
		try
		{
			addStudent();
			addInstructor();
			addCourse();
			addUser();
			//			editStudent();
			//			findStudent();
			//			deleteStudent();
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
	}

	private static void deleteStudent()
	{
		try
		{
			BusinessLogicCore core = new BusinessLogicCore();
			Student foundStudent = core.find(Student.class, (long) 2);
			core.delete(foundStudent);
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
	}

	private static void findStudent()
	{
		try
		{
			BusinessLogicCore core = new BusinessLogicCore();
			Student foundStudent = core.find(Student.class, (long) 1);
			showEntityResult(foundStudent, "Find");
			System.out.println("first name : " + foundStudent.getName().getFirstName());
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
			Student foundEntity = blCore.find(Student.class, (long) 1);
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
			CompositeName name = new CompositeName();
			name.setFirstName("Ahmed");
			name.setLastName("Ali");
			student.setName(name);
			student.setEmail("ahmed.ali@gmail.com");
			student.setGender(Gender.Male);
			student.setGpa(new BigDecimal(3.0));
			BaseEntity addedStudent = blCore.add(student);
			showEntityResult(addedStudent, " Add Entity");
		}
		catch (Exception e)
		{
			e.printStackTrace();
			HibernateDBManager.rollbackTransaction();
		}
	}

	private static void addCourse()
	{
		try
		{
			BusinessLogicCore blCore = new BusinessLogicCore();
			Course course = new Course();
			course.setName("Data Structure");
			course.setCode("002");
			course.setPreRequest(true);
			Instructor instructor = new Instructor();
			instructor.setId((long) 1);
			course.setInstructor(instructor);
			BaseEntity addedCourse = blCore.add(course);
			showEntityResult(addedCourse, " Add Entity");
		}
		catch (Exception e)
		{
			e.printStackTrace();
			HibernateDBManager.rollbackTransaction();
		}
	}

	private static void addInstructor()
	{
		try
		{
			BusinessLogicCore blCore = new BusinessLogicCore();
			Instructor instructor = new Instructor();
			instructor.setName("dr.Ahmed");
			instructor.setEmail("dr.ahmed@gmail.com");
			instructor.setAddress("Dokki");
			instructor.setPhone("01065102524");
			BaseEntity addedInstructor = blCore.add(instructor);
			showEntityResult(addedInstructor, " Add Entity");
		}
		catch (Exception e)
		{
			e.printStackTrace();
			HibernateDBManager.rollbackTransaction();
		}
	}

	private static void addUser()
	{
		try
		{
			BusinessLogicCore blCore = new BusinessLogicCore();
			User user = new User();
			CompositeName compositeName = new CompositeName();
			compositeName.setFirstName("mohamed");
			compositeName.setLastName("mahmoud");
			user.setName(compositeName);
			user.setEmail("moamed_mahmoud20@gmail.com");
			BaseEntity addedUser = blCore.add(user);
			showEntityResult(addedUser, " Add Entity");
		}
		catch (Exception e)
		{
			e.printStackTrace();
			HibernateDBManager.rollbackTransaction();
		}
	}
}
