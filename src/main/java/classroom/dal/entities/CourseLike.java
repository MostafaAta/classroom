package classroom.dal.entities;

import classroom.dal.details.*;
import classroom.dal.roots.*;

import javax.persistence.*;
import java.util.*;

@Entity
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
public class CourseLike extends BaseEntity
{
	@OneToOne
	private Course course;
	@OneToOne
	private Student student;
	@JoinColumn(name = "courseLike_id")
	@OneToMany(fetch = FetchType.LAZY, orphanRemoval = true, cascade = CascadeType.ALL)
	private List<CourseLikeLine> details;

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

	public List<CourseLikeLine> getDetails()
	{
		return details;
	}

	public void setDetails(List<CourseLikeLine> details)
	{
		this.details = details;
	}
}
