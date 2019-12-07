package classroom.dal.entities;

import classroom.dal.roots.*;

import javax.persistence.*;

@Entity
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
public class Course extends BaseEntity
{
	private Boolean isPreRequest;

	public Course()
	{

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
