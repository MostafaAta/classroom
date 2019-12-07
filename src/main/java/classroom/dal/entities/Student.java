package classroom.dal.entities;

import classroom.dal.entities.Embeddable.*;
import classroom.dal.primitives.*;
import classroom.dal.roots.*;

import javax.persistence.*;
import java.math.*;

@Entity
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
public class Student extends BaseEntity
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
