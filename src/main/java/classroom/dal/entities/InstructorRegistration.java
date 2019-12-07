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

@Entity
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
public class InstructorRegistration extends BaseEntity
{
	@OneToOne
	private Instructor instructor;
	@OneToOne
	private Course course;
	private LocalDateTime registeredAt;
	private BigDecimal grade;
	@Fetch(FetchMode.JOIN)
	@OneToMany(mappedBy = "owner", fetch = FetchType.LAZY, orphanRemoval = true, cascade = CascadeType.ALL)
	private List<InstructorRegistrationLine> details;

	public InstructorRegistration()
	{
	}

	public Instructor getInstructor()
	{
		return instructor;
	}

	public void setInstructor(Instructor instructor)
	{
		this.instructor = instructor;
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

	public List<InstructorRegistrationLine> getDetails()
	{
		return details;
	}

	public void setDetails(List<InstructorRegistrationLine> details)
	{
		this.details = details;
	}
}
