package classroom.domain.common;

public class CriteriaBuilder
{
	private String fieldId;
	private String operator;
	private Object value;

	private CriteriaBuilder(String fieldId, String operator, Object value)
	{
		this.fieldId = fieldId;
		this.operator = operator;
		this.value = value;
	}

	public static CriteriaBuilder createInstanceFor(String fieldId, String operator, Object value)
	{
		boolean notValid = false;
		if (fieldId == null || fieldId.isEmpty())
			notValid = true;
		if (operator == null || operator.isEmpty())
			notValid = true;
		if (notValid)
		{
			System.err.println("fieldId and operator and value: all these fields must have values");
			return null;
		}
		return new CriteriaBuilder(fieldId, operator, value);
	}

	public String getFieldId()
	{
		return fieldId;
	}

	public String getOperator()
	{
		return operator;
	}

	public Object getValue()
	{
		return value;
	}

	@Override
	public String toString()
	{
		return "CriteriaStatement{" + "fieldId='" + fieldId + '\'' + ", operator='" + operator + '\'' + ", value=" + value + '}';
	}
}
