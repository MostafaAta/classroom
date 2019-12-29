package classroom.dal.entities;

import classroom.dal.primitives.*;
import classroom.dal.roots.*;

import javax.persistence.*;
import java.math.*;

@Entity
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
public class Student extends BaseEntity
{
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

	@Override
	public String toString()
	{
		return super.toString() + " Email:  " + getEmail() + " Gender: " + getGender() + " GPA: " + getGpa();
	}
}
