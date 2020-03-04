package classroom.domain.common;

public class FieldMetaData
{
	private String fieldName;
	private UIFieldType fieldType;
	private Object value;
	private Boolean show = true;

	public FieldMetaData()
	{
	}

	public FieldMetaData(String fieldName, Object value)
	{
		this.fieldName = fieldName;
		this.value = value;
	}

	public FieldMetaData(String fieldName, UIFieldType fieldType, Object value)
	{
		this.fieldName = fieldName;
		this.fieldType = fieldType;
		this.value = value;
	}

	public String getFieldName()
	{
		return fieldName;
	}

	public UIFieldType getFieldType()
	{
		return fieldType;
	}

	public Object getValue()
	{
		return value;
	}

	public void setValue(Object value)
	{
		this.value = value;
	}

	public Boolean getShow()
	{
		return show;
	}

	public void setShow(Boolean show)
	{
		this.show = show;
	}
}
