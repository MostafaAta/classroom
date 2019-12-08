package classroom.dal.entities;

import classroom.dal.details.StudentRegistrationLine;
import classroom.dal.roots.BaseEntity;
import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

@Entity
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
public class StudentRegistration extends BaseEntity
{
	@OneToOne
	private Student student;
	@OneToOne
	private Course course;
	private Date registeredAt;
	private BigDecimal grade;
	@Fetch(FetchMode.JOIN)
	@JoinColumn(name = "studentRegistration_id")
	@OneToMany(fetch = FetchType.LAZY, orphanRemoval = true, cascade = CascadeType.ALL)
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

	public List<StudentRegistrationLine> getDetails()
	{
		return details;
	}

	public void setDetails(List<StudentRegistrationLine> details)
	{
		this.details = details;
	}
}
