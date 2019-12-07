package classroom.dal.entities;

import classroom.dal.roots.*;

import javax.persistence.*;

@Entity
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
public class Instructor extends BaseEntity
{
	private String address;
	private String phone;
	private String email;

	public Instructor()
	{
	}

	public Instructor(Long id)
	{
		this.setId(id);
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
