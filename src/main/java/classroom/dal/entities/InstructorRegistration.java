package classroom.dal.entities;

import classroom.dal.details.InstructorRegistrationLine;
import classroom.dal.roots.BaseEntity;
import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

@Entity
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
public class InstructorRegistration extends BaseEntity
{
	@OneToOne
	private Instructor instructor;
	@OneToOne
	private Course course;
	private Date registeredAt;
	private BigDecimal grade;
	@Fetch(FetchMode.JOIN)
	@JoinColumn(name = "instructorRegistration_id")
	@OneToMany(fetch = FetchType.LAZY, orphanRemoval = true, cascade = CascadeType.ALL)
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

	public Date getRegisteredAt()
	{
		return registeredAt;
	}

	public void setRegisteredAt(Date registeredAt)
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
