package entities;

import entities.Embeddable.CourseRatingKey;

import javax.persistence.*;
import java.io.Serializable;
import java.math.BigDecimal;

@Entity
@Table(name = "course_rating")
public class CourseRating implements Serializable
{
	@EmbeddedId
	private CourseRatingKey id;
	@ManyToOne
	@MapsId("student_id")
	@JoinColumn(name = "student_id")
	private Student student;
	@ManyToOne
	@MapsId("course_id")
	@JoinColumn(name = "course_id")
	private Course course;
	private BigDecimal rating;

	public CourseRatingKey getId()
	{
		return id;
	}

	public void setId(CourseRatingKey id)
	{
		this.id = id;
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
}
