package classroom.dal.entities;

import classroom.dal.details.*;
import classroom.dal.roots.*;
import org.hibernate.annotations.*;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.*;
import java.math.*;
import java.time.*;
import java.util.*;

@Entity(name = "student_reg")
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
public class StudentRegistration extends BaseEntity
{
	@OneToOne
	private Student student;
	@OneToOne
	private Course course;
	private LocalDateTime registeredAt;
	private BigDecimal grade;
	@Fetch(FetchMode.JOIN)
	@OneToMany(mappedBy = "owner", fetch = FetchType.LAZY, orphanRemoval = true, cascade = CascadeType.ALL)
	private List<StudentRegistrationLine> details;

	public StudentRegistration()
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

	public List<StudentRegistrationLine> getDetails()
	{
		return details;
	}

	public void setDetails(List<StudentRegistrationLine> details)
	{
		this.details = details;
	}
}
