package classroom.dal.details;

import classroom.dal.entities.Course;
import classroom.dal.entities.Student;

import javax.persistence.*;
import java.math.BigDecimal;

@Entity
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
public class CourseRatingLine extends RootLine
{
	@ManyToOne
	private Course course;
	@ManyToOne
	private Student student;
	private BigDecimal rating;

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

	public BigDecimal getRating()
	{
		return rating;
	}

	public void setRating(BigDecimal rating)
	{
		this.rating = rating;
	}
}
