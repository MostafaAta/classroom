package classroom.dal.details;

import classroom.dal.entities.*;
import classroom.dal.valueobjects.*;

import javax.persistence.*;
import java.math.*;
import java.util.*;

@Entity
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
public class CourseRegistrationLine extends RootLine
{
	@ManyToOne
	private Course course;
	private EntityRef entityRef;
	private Date registeredAt;
	private BigDecimal grade;

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
}
