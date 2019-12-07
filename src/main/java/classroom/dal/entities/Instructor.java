package classroom.dal.entities;

import javax.persistence.Entity;
import javax.persistence.OneToMany;
import java.io.Serializable;
import java.util.List;

@Entity
public class Instructor extends BaseEntity implements Serializable
{
	private String name;
	private String address;
	private String phone;
	private String email;

	public Instructor()
	{
	}

	public Instructor(String name, String address, String phone, String email, List<Course> courses)
	{
		this.name = name;
		this.address = address;
		this.phone = phone;
		this.email = email;
		this.courses = courses;
	}

	public Instructor(Long id)
	{
		this.setId(id);
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
}
