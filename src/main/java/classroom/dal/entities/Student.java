package classroom.dal.entities;

import classroom.dal.primitives.*;
import classroom.dal.roots.*;
import classroom.domain.common.*;

import javax.persistence.*;
import java.math.*;
import java.util.*;

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

	@Override
	public void addFieldMetaDataTo(List<FieldMetaData> metaData)
	{
		super.addFieldMetaDataTo(metaData);
		metaData.add(new FieldMetaData("Email", UIFieldType.IntegerNumber, "1.1@1.com"));
	}

	@Override
	public List<TableHeaderMetaData> tableHeaders()
	{
		List<TableHeaderMetaData> metaData = super.tableHeaders();
		metaData.add(new TableHeaderMetaData("Email", -1));
		return metaData;
	}
}
