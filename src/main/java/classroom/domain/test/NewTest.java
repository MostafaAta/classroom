package classroom.domain.test;

import classroom.dal.details.*;
import classroom.dal.entities.*;
import classroom.dal.hibernate.*;
import classroom.dal.roots.*;
import classroom.dal.valueobjects.*;
import classroom.domain.common.*;
import org.hibernate.*;
import org.hibernate.criterion.*;

import java.math.*;
import java.util.*;

public class NewTest
{
	private static final boolean clearData = true;
	private static List<Student> students = new ArrayList<>();
	private static List<Course> courses = new ArrayList<>();
	private static List<Instructor> instructors = new ArrayList<>();
	private static BusinessLogicCore core;

	public static NewTest instance()
	{
		return new NewTest();
	}

	public NewTest()
	{
		try
		{
			core = new BusinessLogicCore<>();
		}
		catch (Throwable e)
		{
			e.printStackTrace();
		}
	}

	private void clearData(boolean forceClearData)
	{
		if (!forceClearData && clearData)
			return;
		clearData(CourseLikeLine.class.getSimpleName());
		clearData(CourseLike.class.getSimpleName());
		clearData(CourseRatingLine.class.getSimpleName());
		clearData(CourseRating.class.getSimpleName());
		clearData(CourseRegistration.class.getSimpleName());
		clearData(CourseRegistrationLine.class.getSimpleName());
		clearData(Student.class.getSimpleName());
		clearData(Instructor.class.getSimpleName());
		clearData(Course.class.getSimpleName());
		clearData(ClassroomUser.class.getSimpleName());
	}

	private void clearData(String tableName)
	{
		try
		{
			HibernateDBManager.setDbConfigFileName("hibernate.cfg.xml");
			HibernateDBManager.buildSessionFactory();
			Session commonRepo = HibernateDBManager.getCommonRepo();
			HibernateDBManager.beginTransaction();
			int result = commonRepo.createSQLQuery("delete from " + tableName).executeUpdate();
			HibernateDBManager.commitTransaction();
			System.out.println(tableName + " is dropped with result : " + result);
		}
		catch (Throwable e)
		{
			HibernateDBManager.rollbackTransaction();
			e.printStackTrace();
		}
	}

	public void createScenario(boolean forceClearData)
	{
		try
		{
			clearData(forceClearData);
			addStudents();
			addCourses();
			addInstructors();
			addCourseLike();
			addCourseRegistration();
			addCourseRating();
			addUser();
		}
		catch (Throwable e)
		{
			e.printStackTrace();
		}
	}

	private void addUser() throws Throwable
	{
		ClassroomUser user = new ClassroomUser();
		user.setCode("00a");
		user.setName1("mostafa");
		user.setName2("atta");
		user.setEmail("ata@gmail.com");
		user.setPassword("123");
		core.add(user);
	}

	private void addStudents() throws Throwable
	{
		for (int i = 0; i < 10; i++)
		{
			Student student = new Student();
			student.setCode("Student " + (i + 1));
			student.setName1(student.getCode());
			student.setName2(student.getCode());
			core.add(student);
			students.add(student);
		}
	}

	private void addCourses() throws Throwable
	{
		for (int i = 0; i < 1; i++)
		{
			Course course = new Course();
			course.setCode("Course " + (i + 1));
			course.setName1(course.getCode());
			course.setName2(course.getCode());
			core.add(course);
			courses.add(course);
		}
	}

	private void addInstructors() throws Throwable
	{
		for (int i = 0; i < 10; i++)
		{
			Instructor instructor = new Instructor();
			instructor.setCode("Instructor " + (i + 1));
			instructor.setName1(instructor.getCode());
			instructor.setName2(instructor.getCode());
			instructors.add(instructor);
			core.add(instructor);
		}
	}

	private void addCourseLike() throws Throwable
	{
		CourseLike like = new CourseLike();
		like.setCode("Course like 1");
		like.setName1(like.getCode());
		like.setName2(like.getCode());
		like.setDetails(new ArrayList<>());
		for (Student student : students)
		{
			CourseLikeLine line = new CourseLikeLine();
			like.getDetails().add(line);
			line.setCourse(courses.get(0));
			line.setStudent(student);
		}
		core.add(like);
	}

	private void addCourseRegistration() throws Throwable
	{
		CourseRegistration registration = new CourseRegistration();
		registration.setCode("Course Registration 1");
		registration.setName1(registration.getCode());
		registration.setName2(registration.getCode());
		registration.setDetails(new ArrayList<>());
		for (Instructor instructor : instructors)
		{
			CourseRegistrationLine line = new CourseRegistrationLine();
			registration.getDetails().add(line);
			line.setCourse(courses.get(0));
			line.setEntityRef(EntityRef.fromReal(instructor));
			line.setGrade(BigDecimal.valueOf(Math.random() * 151));
			line.setRegisteredAt(new Date());
		}
		for (Student student : students)
		{
			CourseRegistrationLine line = new CourseRegistrationLine();
			registration.getDetails().add(line);
			line.setCourse(courses.get(0));
			line.setEntityRef(EntityRef.fromReal(student));
			line.setGrade(BigDecimal.valueOf(Math.random() * 151));
			line.setRegisteredAt(new Date());
		}
		core.add(registration);
	}

	private void addCourseRating() throws Throwable
	{
		CourseRating rating = new CourseRating();
		rating.setCode("Rating 1");
		rating.setName1(rating.getCode());
		rating.setName2(rating.getCode());
		rating.setDetails(new ArrayList<>());
		for (Student student : students)
		{
			CourseRatingLine line = new CourseRatingLine();
			rating.getDetails().add(line);
			line.setCourse(courses.get(0));
			line.setStudent(student);
			line.setRating(BigDecimal.valueOf(Math.random() * 99 + 1));
		}
		core.add(rating);
	}

	public void showScenario() throws Throwable
	{
		//		showCourseRating(CourseRegistration.class);
		showStudents(Student.class);
	}

	private <T extends Persistable> void showStudents(Class<T> studentClass) throws Throwable
	{
		CriteriaBuilder criteria = CriteriaBuilder.createInstanceFor("name1", CriteriaStatementUtility.like, "1");
		List<T> byLikeList = core.findByLike(studentClass, MatchMode.END, criteria);
		for (T o : byLikeList)
		{
			System.out.println(((Student) o).getName1());
		}
	}

	private <T extends Persistable> void showCourseRating(Class<T> courseRating) throws Throwable
	{
		List<T> allCourseRating = core.findAll(courseRating);
		for (T rating : allCourseRating)
		{
			System.out.println(rating);
			System.out.println(((CourseRegistration) rating).getDetails());
		}
	}
}
