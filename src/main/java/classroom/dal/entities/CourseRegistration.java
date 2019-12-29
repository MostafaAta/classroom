package classroom.dal.entities;

import classroom.dal.details.*;
import classroom.dal.roots.*;
import classroom.dal.valueobjects.*;

import javax.persistence.*;
import java.math.*;
import java.util.*;

@Entity
public class CourseRegistration extends BaseEntity
{
	private EntityRef entityRef;
	@OneToOne
	private Course course;
	private Date registeredAt;
	private BigDecimal grade;
	@JoinColumn(name = "courseRegistration_id")
	@OneToMany(fetch = FetchType.LAZY, orphanRemoval = true, cascade = CascadeType.ALL)
	private List<CourseRegistrationLine> details;

	public EntityRef getEntityRef()
	{
		return entityRef;
	}

	public void setEntityRef(EntityRef entityRef)
	{
		this.entityRef = entityRef;
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

	public List<CourseRegistrationLine> getDetails()
	{
		return details;
	}

	public void setDetails(List<CourseRegistrationLine> details)
	{
		this.details = details;
	}
}
