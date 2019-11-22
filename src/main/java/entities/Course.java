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
	private String name1;
	private Boolean isPreRequest;
	@ManyToOne(fetch = FetchType.LAZY)
	Instructor instructor; // not sure from that annotation

	public Integer getId()
	{
		return id;
	}

	public void setId(Integer id)
	{
		this.id = id;
	}

	public String getName1()
	{
		return name1;
	}

	public void setName1(String name1)
	{
		this.name1 = name1;
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
		return "Course{" + "id=" + id + ", name1='" + name1 + '\'' + ", isPreRequest=" + isPreRequest + ", instructor=" + instructor + '}';
	}

	@Override
	public boolean equals(Object o)
	{
		if (this == o)
			return true;
		if (o == null || getClass() != o.getClass())
			return false;
		Course course = (Course) o;
		return Objects.equals(id, course.id) && Objects.equals(name1, course.name1) && Objects.equals(isPreRequest, course.isPreRequest) && Objects
				.equals(instructor, course.instructor);
	}

	@Override
	public int hashCode()
	{
		return Objects.hash(id, name1, isPreRequest, instructor);
	}
}
