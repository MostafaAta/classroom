package classroom.domain.common;

import classroom.dal.roots.*;

import java.util.*;

public class TableUIUtil
{
	public static <T extends BaseEntity> List<TableHeaderMetaData> tableHeaders(Class<T> klass)
	{
		T entity = createInstance(klass);
		if (entity == null)
			return new ArrayList<>();
		return entity.tableHeaders();
	}

	private static <T extends BaseEntity> T createInstance(Class<T> klass)
	{
		try
		{
			return klass.newInstance();
		}
		catch (IllegalAccessException | InstantiationException e)
		{
			e.printStackTrace();
			return null;
		}
	}
}
