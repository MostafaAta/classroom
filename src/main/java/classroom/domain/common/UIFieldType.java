package classroom.domain.common;

public enum UIFieldType
{
	Text, BigText, HashedText, IntegerNumber, DoubleNumber, EntityReference, Boolean, Date, DateTime, GenericReference, Enum;

	public boolean isText()
	{
		return this.equals(Text);
	}
}
