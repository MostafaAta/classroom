package classroom.domain.test;

import classroom.dal.entities.*;
import classroom.dal.entities.Embeddable.CompositeName;
import classroom.dal.hibernate.HibernateDBManager;
import classroom.dal.primitives.Gender;

import java.math.BigDecimal;
import java.util.HashSet;
import java.util.Set;

public class DomainTestMain
{
	public static void main(String[] args)
	{
		try
		{
			//			addStudent();
			//			addInstructor();
			//			addCourse();
			//			editCourse();
			//			addUser();
			editStudent();
			//			findStudent();
			//			deleteStudent();
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
	}

	private static void editCourse()
	{
		try
		{
			BusinessLogicCore blCore = new BusinessLogicCore();
			Course foundEntity = blCore.find(Course.class, (long) 5);
			foundEntity.setPreRequest(true);
			BaseEntity editCourse = blCore.edit(foundEntity);
			showEntityResult(editCourse, "Edit");
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
			Student student = blCore.find(Student.class, (long) 7);
			Set<Course> likedCourses = new HashSet<>();
			likedCourses.add(new Course((long) 4));
			likedCourses.add(new Course((long) 2));
			student.setLikedCourses(likedCourses);
			BaseEntity editStudent = blCore.edit(student);
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
			student.setName(new CompositeName("Mohamed", "trika"));
			student.setEmail("trika@gmail.com");
			student.setGender(Gender.Male);
			student.setGpa(new BigDecimal(4));
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
			course.setName("gis");
			course.setCode("105");
			course.setPreRequest(true);
			course.setInstructor(new Instructor((long) 7));
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
			instructor.setName("dr.Yasser");
			instructor.setEmail("dr.abdalla@yahoo.com");
			instructor.setAddress("Aswan");
			instructor.setPhone("89446566");
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
