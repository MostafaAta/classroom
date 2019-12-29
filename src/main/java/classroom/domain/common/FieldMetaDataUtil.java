package classroom.domain.common;

import classroom.dal.roots.*;

import java.util.*;

public class FieldMetaDataUtil
{
	public static <T extends BaseEntity> List<FieldMetaData> createFieldsMetaDataFrom(T entity)
	{
		List<FieldMetaData> metaData = new ArrayList<>();
		entity.addFieldMetaDataTo(metaData);
		return metaData;
	}
}
