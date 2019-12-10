package classroom.domain.test;

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
			//			editStudent();
			//			findStudent();
			//			deleteStudent();
			//			addCourseRatings();
			//			addCourseRegistration();
			NewTest.createScenario(true);
			NewTest.showScenario();
		}
		catch (Throwable e)
		{
			e.printStackTrace();
		}
	}

//	private static void addCourseRegistration()
//	{
//		try
//		{
//			BusinessLogicCore core = new BusinessLogicCore();
//			Student student = core.find(Student.class, (long) 1);
//			Course course = core.find(Course.class, (long) 1);
//			StudentRegistration registration = new StudentRegistration();
//			registration.setStudent(student);
//			registration.setCourse(course);
//			registration.setGrade(BigDecimal.valueOf(4));
//			BaseEntity addedRegistration = core.add(registration);
//			showEntityResult(addedRegistration, "Added");
//		}
//		catch (Throwable e)
//		{
//			e.printStackTrace();
//		}
//	}
//
//	private static void editCourse()
//	{
//		try
//		{
//			BusinessLogicCore blCore = new BusinessLogicCore();
//			Course foundEntity = blCore.find(Course.class, (long) 5);
//			foundEntity.setPreRequest(true);
//			BaseEntity editCourse = blCore.edit(foundEntity);
//			showEntityResult(editCourse, "Edit");
//		}
//		catch (Throwable e)
//		{
//			e.printStackTrace();
//		}
//	}
//
//	private static void deleteStudent()
//	{
//		try
//		{
//			BusinessLogicCore core = new BusinessLogicCore();
//			Student foundStudent = core.find(Student.class, (long) 2);
//			core.delete(foundStudent);
//		}
//		catch (Throwable e)
//		{
//			e.printStackTrace();
//		}
//	}
//
//	private static void findStudent()
//	{
//		try
//		{
//			BusinessLogicCore core = new BusinessLogicCore();
//			Student foundStudent = core.find(Student.class, (long) 1);
//			showEntityResult(foundStudent, "Find");
//			System.out.println("first name : " + foundStudent.getName1());
//		}
//		catch (Throwable e)
//		{
//			e.printStackTrace();
//		}
//	}
//
//	private static void editStudent()
//	{
//		try
//		{
//			BusinessLogicCore blCore = new BusinessLogicCore();
//			Student student = blCore.find(Student.class, (long) 8);
//			Set<Course> likedCourses = new HashSet<>();
//			//			Course course = new Course((long) 5);
//			//			likedCourses.add(course);
//			//			student.setLikedCourses(likedCourses);
//			BaseEntity editStudent = blCore.edit(student);
//			showEntityResult(editStudent, "Edit");
//		}
//		catch (Throwable e)
//		{
//			e.printStackTrace();
//		}
//	}
//
//	private static void showEntityResult(BaseEntity entity, String type)
//	{
//		System.out.println(type + "   >>     id : " + entity.getId());
//	}
//
//	private static void addStudent()
//	{
//		try
//		{
//			BusinessLogicCore blCore = new BusinessLogicCore();
//			Student student = new Student();
//			student.setName1("Amal");
//			student.setEmail("amal@gmail.com");
//			student.setGender(Gender.Female);
//			student.setGpa(BigDecimal.valueOf(2.1));
//			BaseEntity addedStudent = blCore.add(student);
//			showEntityResult(addedStudent, " Add Entity");
//		}
//		catch (Throwable e)
//		{
//			e.printStackTrace();
//			HibernateDBManager.rollbackTransaction();
//		}
//	}
//
//	private static void addCourse()
//	{
//		try
//		{
//			BusinessLogicCore blCore = new BusinessLogicCore();
//			Course course = new Course();
//			course.setCode("054");
//			//			course.setName("gis");
//			course.setPreRequest(true);
//			//			course.setInstructor(new Instructor((long) 6));
//			BaseEntity addedCourse = blCore.add(course);
//			showEntityResult(addedCourse, " Add Entity");
//		}
//		catch (Throwable e)
//		{
//			e.printStackTrace();
//			HibernateDBManager.rollbackTransaction();
//		}
//	}
//
//	private static void addInstructor()
//	{
//		try
//		{
//			BusinessLogicCore blCore = new BusinessLogicCore();
//			//			BaseEntity addedInstructor = blCore.add(new Instructor("dr.Yasser", "Aswan", "068654989", "dr.yasser@gmail.com", null));
//			//			showEntityResult(addedInstructor, " Add Entity");
//		}
//		catch (Throwable e)
//		{
//			e.printStackTrace();
//			HibernateDBManager.rollbackTransaction();
//		}
//	}
//
//	private static void addUser()
//	{
//		try
//		{
//			BusinessLogicCore blCore = new BusinessLogicCore();
//			User user = new User();
//			user.setName1("mohamed");
//			user.setName2("mahmoud");
//			user.setEmail("moamed_mahmoud20@gmail.com");
//			BaseEntity addedUser = blCore.add(user);
//			showEntityResult(addedUser, " Add Entity");
//		}
//		catch (Throwable e)
//		{
//			e.printStackTrace();
//			HibernateDBManager.rollbackTransaction();
//		}
//	}
}
