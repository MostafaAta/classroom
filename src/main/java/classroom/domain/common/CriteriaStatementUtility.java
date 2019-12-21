package classroom.domain.common;

import org.hibernate.*;
import org.hibernate.criterion.*;

import java.util.*;

public class CriteriaStatementUtility
{
	public static final String EQUAL = "=";

	public static void addRestrictionsToCriteriaFrom(List<CriteriaBuilder> statements, Criteria criteria) throws Exception
	{
		if (statements == null || statements.isEmpty())
			return;
		for (CriteriaBuilder statement : statements)
		{
			if (statement == null)
				continue;
			Criterion criterion = createCriterionFrom(statement);
			criteria.add(criterion);
		}
	}

	private static Criterion createCriterionFrom(CriteriaBuilder statement) throws Exception
	{
		String operator = statement.getOperator();
		switch (operator)
		{
		case EQUAL:
			return Restrictions.eq(statement.getFieldId(), statement.getValue());
		}
		throw new Exception("Not Supported Statement : " + statement);
	}
}
