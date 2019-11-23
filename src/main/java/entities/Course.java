package entities;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Objects;

@Entity
public class Course implements Serializable
{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	private String name;
	private Boolean isPreRequest;
	private String code;
	@ManyToOne
	private Instructor instructor;

	public String getCode()
	{
		return code;
	}

	public void setCode(String code)
	{
		this.code = code;
	}

	public Integer getId()
	{
		return id;
	}

	public void setId(Integer id)
	{
		this.id = id;
	}

	public String getName()
	{
		return name;
	}

	public void setName(String name1)
	{
		this.name = name1;
	}

	public Boolean getPreRequest()
	{
		return isPreRequest;
	}

	public void setPreRequest(Boolean preRequest)
	{
		isPreRequest = preRequest;
	}

	public Instructor getInstructor()
	{
		return instructor;
	}

	public void setInstructor(Instructor instructor)
	{
		this.instructor = instructor;
	}

	@Override
	public String toString()
	{
		return "Course{" + "id=" + id + ", name1='" + name + '\'' + ", isPreRequest=" + isPreRequest + ", instructor=" + instructor + '}';
	}

	@Override
	public boolean equals(Object o)
	{
		if (this == o)
			return true;
		if (o == null || getClass() != o.getClass())
			return false;
		Course course = (Course) o;
		return Objects.equals(id, course.id) && Objects.equals(name, course.name) && Objects.equals(isPreRequest, course.isPreRequest) && Objects
				.equals(instructor, course.instructor);
	}

	@Override
	public int hashCode()
	{
		return Objects.hash(id, name, isPreRequest, instructor);
	}
}
