package classroom.dal.details;

import classroom.dal.entities.*;

import javax.persistence.*;
import java.math.*;
import java.time.*;

@Entity(name = "student_reg_line")
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
public class StudentRegistrationLine extends RootLine
{
	@ManyToOne
	private Course course;
	@ManyToOne
	private Student student;
	private LocalDateTime registeredAt;
	private BigDecimal grade;
	@ManyToOne
	@JoinColumn
	StudentRegistration owner;

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

	public StudentRegistration getOwner()
	{
		return owner;
	}

	public void setOwner(StudentRegistration owner)
	{
		this.owner = owner;
	}
}
