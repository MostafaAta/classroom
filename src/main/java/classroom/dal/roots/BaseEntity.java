package classroom.dal.roots;

import javax.persistence.*;

@MappedSuperclass
public abstract class BaseEntity extends Persistable
{
	@Column(unique = true)
	private String code;
	@Column(unique = true)
	private String name1;
	@Column(unique = true)
	private String name2;

	public String getCode()
	{
		return code;
	}

	public void setCode(String code)
	{
		this.code = code;
	}

	public String getName1()
	{
		return name1;
	}

	public void setName1(String name1)
	{
		this.name1 = name1;
	}

	public String getName2()
	{
		return name2;
	}

	public void setName2(String name2)
	{
		this.name2 = name2;
	}
}

