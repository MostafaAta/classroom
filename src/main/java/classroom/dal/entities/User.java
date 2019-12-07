package classroom.dal.entities;

import classroom.dal.entities.Embeddable.*;
import classroom.dal.roots.*;

import javax.persistence.*;

@Entity
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
public class User extends BaseEntity
{
	private CompositeName name;
	private String email;

	public String getEmail()
	{
		return email;
	}

	public void setEmail(String email)
	{
		this.email = email;
	}

	public CompositeName getName()
	{
		return name;
	}

	public void setName(CompositeName name)
	{
		this.name = name;
	}
}

