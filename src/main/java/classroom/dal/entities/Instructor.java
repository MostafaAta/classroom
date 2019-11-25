package classroom.dal.entities;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;
import java.util.Objects;

@Entity
public class Instructor implements Serializable
{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	private String name;
	private String address;
	private String phone;
	private String email;
	@OneToMany(mappedBy = "instructor")
	private List<Course> courses;

	public List<Course> getCourses()
	{
		return courses;
	}

	public void setCourses(List<Course> course)
	{
		this.courses = course;
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

	public void setName(String name)
	{
		this.name = name;
	}

	public String getAddress()
	{
		return address;
	}

	public void setAddress(String address)
	{
		this.address = address;
	}

	public String getPhone()
	{
		return phone;
	}

	public void setPhone(String phone)
	{
		this.phone = phone;
	}

	public String getEmail()
	{
		return email;
	}

	public void setEmail(String email)
	{
		this.email = email;
	}

	@Override
	public String toString()
	{
		return "Instructor{" + "id=" + id + ", name='" + name + '\'' + ", address='" + address + '\'' + ", phone='" + phone + '\'' + ", email='"
				+ email + '\'' + '}';
	}

	@Override
	public boolean equals(Object o)
	{
		if (this == o)
			return true;
		if (o == null || getClass() != o.getClass())
			return false;
		Instructor that = (Instructor) o;
		return Objects.equals(id, that.id) && Objects.equals(name, that.name) && Objects.equals(address, that.address) && Objects
				.equals(phone, that.phone) && Objects.equals(email, that.email);
	}

	@Override
	public int hashCode()
	{
		return Objects.hash(id, name, address, phone, email);
	}
}
