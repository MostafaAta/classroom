package classroom.dal.entities;

import classroom.dal.details.CourseLikeLine;
import classroom.dal.roots.BaseEntity;
import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

import javax.persistence.*;
import java.util.List;

@Entity
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
public class CourseLike extends BaseEntity
{
	@OneToOne
	private Course course;
	@OneToOne
	private Student student;
	@Fetch(FetchMode.JOIN)
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
