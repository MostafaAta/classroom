package classroom.util;

import classroom.dal.entities.*;
import classroom.dal.roots.*;

public class CommonUtil
{

	public static BaseEntity createInstanceFrom(Object o)
	{
		if (!(o instanceof Class))
			return null;
		return createInstanceFromClass((Class<? extends BaseEntity>) o);
	}

	private static BaseEntity createInstanceFromClass(Class<? extends BaseEntity> klass)
	{
		try
		{
			return klass.newInstance();
		}
		catch (Exception e)
		{
			return null;
		}
	}

	public static Class<? extends BaseEntity> calculateClassFrom(String className)
	{
		className = className == null ? "Course" : className;
		switch (className)
		{
		case "Student":
			return Student.class;
		case "Course":
			return Course.class;
		case "Instructor":
			return Instructor.class;
		case "CourseLike":
			return CourseLike.class;
		case "CourseRegistration":
			return CourseRegistration.class;
		case "CourseRating":
			return CourseRating.class;
		}
		return null;
	}
}
