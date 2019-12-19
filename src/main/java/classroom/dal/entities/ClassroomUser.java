package classroom.dal.entities;

import classroom.dal.roots.*;

import javax.persistence.*;

@Entity
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
public class ClassroomUser extends BaseEntity
{
	String password;
	private String email;

	public String getPassword()
	{
		return password;
	}

	public void setPassword(String password)
	{
		this.password = password;
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
		return super.toString() + "Email " + getEmail();
	}
}

