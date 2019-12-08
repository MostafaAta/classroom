package classroom.dal.details;

import classroom.dal.entities.Course;
import classroom.dal.entities.Student;

import javax.persistence.Entity;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.ManyToOne;

@Entity
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
public class CourseLikeLine extends RootLine
{
	@ManyToOne
	private Course course;
	@ManyToOne
	private Student student;

	public Course getCourse()
	{
		return course;
	}

	public void setCourse(Course course)
	{
		this.course = course;
	}

	public Student getStudent()
	{
		return student;
	}

	public void setStudent(Student student)
	{
		this.student = student;
	}
}
