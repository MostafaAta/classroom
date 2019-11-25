package classroom.dal.entities;

import classroom.dal.entities.Embeddable.CompositeName;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "User")
public class User implements Serializable
{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
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

	public Integer getId()
	{
		return id;
	}

	public void setId(Integer id)
	{
		this.id = id;
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

