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
			addInstructor();
			//			addCourse();
			//			editCourse();
			//			addUser();
			//			editStudent();
			//			findStudent();
			//			deleteStudent();
			//			addCourseRatings();
			//			addCourseRegistration();
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
	}

	private static void addCourseRegistration()
	{
		try
		{
			BusinessLogicCore core = new BusinessLogicCore();
			Student student = core.find(Student.class, (long) 1);
			Course course = core.find(Course.class, (long) 1);
			CourseRegistration registration = new CourseRegistration();
			registration.setStudent(student);
			registration.setCourse(course);
			registration.setGrade(BigDecimal.valueOf(4));
			BaseEntity addedRegistration = core.add(registration);
			showEntityResult(addedRegistration, "Added");
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
	}

	private static void addCourseRatings()
	{
		try
		{
			BusinessLogicCore blCore = new BusinessLogicCore();
			CourseRating courseRating = new CourseRating();
			courseRating.setId((long) 1);
			Student student = blCore.find(Student.class, (long) 1);
			Course course = blCore.find(Course.class, (long) 1);
			courseRating.setStudent(student);
			courseRating.setCourse(course);
			courseRating.setRating(new BigDecimal(2.9));
			BaseEntity addedCourseRating = blCore.add(courseRating);
			showEntityResult(addedCourseRating, "Added");
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
			student.setName(new CompositeName("Amal", "Qandel"));
			student.setEmail("amal@gmail.com");
			student.setGender(Gender.Female);
			student.setGpa(new BigDecimal(2.1));
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
			course.setCode("105");
			course.setName("001");
			course.setPreRequest(true);
			course.setInstructor(new Instructor((long) 1));
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
			BaseEntity addedInstructor = blCore.add(new Instructor("dr.Yasser", "Aswan", "068654989", "dr.yasser@gmail.com", null));
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
