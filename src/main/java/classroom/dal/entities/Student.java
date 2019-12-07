package classroom.dal.entities;

import classroom.dal.primitives.Gender;
import classroom.dal.roots.BaseEntity;

import javax.persistence.Entity;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import java.math.BigDecimal;

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

}
