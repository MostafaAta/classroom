package classroom.dal.entities;

import classroom.dal.entities.Embeddable.CompositeName;

import javax.persistence.Entity;
import javax.persistence.Table;
import java.io.Serializable;

@Entity
@Table(name = "User")
public class User extends BaseEntity implements Serializable
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

