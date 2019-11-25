package classroom.dal.entities;

import javax.persistence.*;
import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDateTime;

@Entity
@Table(name = "course_reg")
public class CourseRegistration implements Serializable
{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@ManyToOne
	@JoinColumn(name = "student_id")
	Student student;
	@ManyToOne
	@JoinColumn(name = "course_id")
	Course course;
	LocalDateTime registeredAt;
	private BigDecimal grade;

	public Long getId()
	{
		return id;
	}

	public void setId(Long id)
	{
		this.id = id;
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
}
