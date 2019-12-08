package classroom.dal.entities;

import classroom.dal.roots.*;

import javax.persistence.*;
import java.math.BigDecimal;

@Entity
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
public class Course extends BaseEntity
{
	BigDecimal numOfHours;
	private Boolean isPreRequest;

	public Course()
	{

	}

	public BigDecimal getNumOfHours()
	{
		return numOfHours;
	}

	public void setNumOfHours(BigDecimal numOfHours)
	{
		this.numOfHours = numOfHours;
	}

	public Boolean getPreRequest()
	{
		return isPreRequest;
	}

	public void setPreRequest(Boolean preRequest)
	{
		isPreRequest = preRequest;
	}
}
