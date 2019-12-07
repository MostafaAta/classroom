package classroom.dal.details;

import classroom.dal.entities.*;

import javax.persistence.*;

@Entity(name = "course_like_line")
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
public class CourseLikeLine extends RootLine
{
	@ManyToOne
	private Course course;
	@ManyToOne
	private Student student;
	@ManyToOne
	@JoinColumn
	CourseLike owner;

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

	public CourseLike getOwner()
	{
		return owner;
	}

	public void setOwner(CourseLike owner)
	{
		this.owner = owner;
	}
}
