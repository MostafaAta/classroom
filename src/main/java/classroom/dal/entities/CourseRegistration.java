package classroom.dal.entities;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDateTime;

@Entity
@Table(name = "course_reg")
public class CourseRegistration extends BaseEntity implements Serializable
{
	@ManyToOne
	@JoinColumn(name = "student_id")
	Student student;
	@ManyToOne
	@JoinColumn(name = "course_id")
	Course course;
	LocalDateTime registeredAt;
	private BigDecimal grade;

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
}
