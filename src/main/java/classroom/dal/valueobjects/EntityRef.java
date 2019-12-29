package classroom.dal.valueobjects;

import classroom.dal.roots.*;
import classroom.domain.test.*;

import javax.persistence.*;

@Embeddable
public class EntityRef
{
	@Column(name = "entity_id")
	private Long id;
	@Column(name = "entity_code")
	private String code;
	@Column(name = "class_type")
	private String classType;

	public EntityRef()
	{
	}

	public EntityRef(Long id, String code, String classType)
	{
		this.id = id;
		this.code = code;
		this.classType = classType;
	}

	public static <T extends BaseEntity> EntityRef fromReal(T entity)
	{
		return new EntityRef(entity.getId(), entity.getCode(), entity.getClass().getSimpleName());
	}

	public static <T extends BaseEntity> T toReal(EntityRef ref)
	{
		try
		{
			BusinessLogicCore<T> core = (BusinessLogicCore<T>) BusinessLogicCore.get();
			return core.find(ref.getClassType(), ref.getId());
		}
		catch (Throwable e)
		{
			e.printStackTrace();
			return null;
		}
	}

	public Long getId()
	{
		return id;
	}

	public void setId(Long id)
	{
		this.id = id;
	}

	public String getCode()
	{
		return code;
	}

	public void setCode(String code)
	{
		this.code = code;
	}

	public String getClassType()
	{
		return classType;
	}

	public void setClassType(String classType)
	{
		this.classType = classType;
	}
}
