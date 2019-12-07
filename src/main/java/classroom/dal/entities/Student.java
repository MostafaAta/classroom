package classroom.dal.entities;

import classroom.dal.entities.Embeddable.CompositeName;
import classroom.dal.primitives.Gender;

import javax.persistence.*;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Set;

@Entity
public class Student extends BaseEntity implements Serializable
{
	private CompositeName name;
	private String email;
	private Gender gender;
	private BigDecimal gpa;

	public Student()
	{

	}

	public Student(Long id)
	{
		this.setId(id);
	}

	public BigDecimal getGpa()
	{
		return gpa;
	}

	public void setGpa(BigDecimal gpa)
	{
		this.gpa = gpa;
	}

	public CompositeName getName()
	{
		return name;
	}

	public void setName(CompositeName name)
	{
		this.name = name;
	}

	public String getEmail()
	{
		return email;
	}

	public void setEmail(String email)
	{
		this.email = email;
	}

	public Gender getGender()
	{
		return gender;
	}

	public void setGender(Gender gender)
	{
		this.gender = gender;
	}

}
