package classroom.domain.common;

public class TableHeaderMetaData
{
	private String name;
	private Integer order;
	private Boolean show = true;

	public TableHeaderMetaData(String name, Integer order)
	{
		this.name = name;
		this.order = order;
	}

	public String getName()
	{
		return name;
	}

	public void setName(String name)
	{
		this.name = name;
	}

	public Integer getOrder()
	{
		return order;
	}

	public void setOrder(Integer order)
	{
		this.order = order;
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
