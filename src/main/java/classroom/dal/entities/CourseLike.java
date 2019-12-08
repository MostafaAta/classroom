package classroom.dal.entities;

import classroom.dal.details.*;
import classroom.dal.roots.*;
import org.hibernate.annotations.*;

import javax.persistence.*;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import java.util.*;

@Entity(name = "course_like")
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
public class CourseLike extends BaseEntity
{
	@OneToOne
	private Course course;
	@OneToOne
	private Student student;
	@Fetch(FetchMode.JOIN)
	@OneToMany(mappedBy = "owner", fetch = FetchType.LAZY, orphanRemoval = true, cascade = CascadeType.ALL)
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
