package classroom.dal.entities;

import classroom.dal.details.*;
import classroom.dal.roots.*;
import org.hibernate.annotations.*;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.*;
import java.math.*;
import java.util.*;

@Entity(name = "course_rating")
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
public class CourseRating extends BaseEntity
{
	@OneToOne
	private Student student;
	@OneToOne
	private Course course;
	private BigDecimal rating;
	@Fetch(FetchMode.JOIN)
	@OneToMany(mappedBy = "owner", fetch = FetchType.LAZY, orphanRemoval = true, cascade = CascadeType.ALL)
	private List<CourseRatingLine> details;

	public CourseRating()
	{
	}

	public Student getStudent()
	{
		return student;
	}

	public void setStudent(Student student)
	{
		this.student = student;
	}

	public Course getCourse()
	{
		return course;
	}

	public void setCourse(Course course)
	{
		this.course = course;
	}

	public BigDecimal getRating()
	{
		return rating;
	}

	public void setRating(BigDecimal rating)
	{
		this.rating = rating;
	}

	public List<CourseRatingLine> getDetails()
	{
		return details;
	}

	public void setDetails(List<CourseRatingLine> details)
	{
		this.details = details;
	}
}
