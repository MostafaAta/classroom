package classroom.dal.details;

import classroom.dal.entities.*;

import javax.persistence.*;
import java.math.*;
import java.time.*;

@Entity(name = "instructor_reg_line")
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
public class InstructorRegistrationLine extends RootLine
{
	@ManyToOne
	private Course course;
	@ManyToOne
	private Instructor instructor;
	private LocalDateTime registeredAt;
	private BigDecimal grade;
	@ManyToOne
	@JoinColumn
	InstructorRegistration owner;

	public Course getCourse()
	{
		return course;
	}

	public void setCourse(Course course)
	{
		this.course = course;
	}

	public Instructor getInstructor()
	{
		return instructor;
	}

	public void setInstructor(Instructor instructor)
	{
		this.instructor = instructor;
	}

	public LocalDateTime getRegisteredAt()
	{
		return registeredAt;
	}

	public void setRegisteredAt(LocalDateTime registeredAt)
	{
		this.registeredAt = registeredAt;
	}

	public BigDecimal getGrade()
	{
		return grade;
	}

	public void setGrade(BigDecimal grade)
	{
		this.grade = grade;
	}

	public InstructorRegistration getOwner()
	{
		return owner;
	}

	public void setOwner(InstructorRegistration owner)
	{
		this.owner = owner;
	}
}
