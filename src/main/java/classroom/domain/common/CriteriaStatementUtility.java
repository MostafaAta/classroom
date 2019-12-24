package classroom.domain.common;

import org.hibernate.*;
import org.hibernate.criterion.*;

import java.util.*;

public class CriteriaStatementUtility
{
	public static final String EQUAL = "=";
	public static final String greaterThan = ">";
	public static final String like = "like";

	public static void addRestrictionsToCriteriaFrom(List<CriteriaBuilder> statements, Criteria criteria) throws Exception
	{
		if (statements == null || statements.isEmpty())
			return;
		for (CriteriaBuilder statement : statements)
		{
			if (statement == null)
				continue;
			Criterion criterion = createCriterionFrom(statement, null);
			criteria.add(criterion);
		}
	}

	public static void findByLike(List<CriteriaBuilder> statements, MatchMode matchMode, Criteria criteria) throws Exception
	{
		if (statements == null || statements.isEmpty())
			return;
		if (matchMode == null)
			matchMode = MatchMode.ANYWHERE;
		for (CriteriaBuilder statement : statements)
		{
			if (statement == null)
				continue;
			Criterion criterion = createCriterionFrom(statement, matchMode);
			criteria.add(criterion);
		}
	}

	private static Criterion createCriterionFrom(CriteriaBuilder statement, MatchMode matchMode) throws Exception
	{
		String operator = statement.getOperator();
		switch (operator)
		{
		case EQUAL:
			return Restrictions.eq(statement.getFieldId(), statement.getValue());
		case greaterThan:
			return Restrictions.gt(statement.getFieldId(), statement.getValue());
		case like:
			return Restrictions.like(statement.getFieldId(), String.valueOf(statement.getValue()), matchMode);
		}
		throw new Exception("Not Supported Statement : " + statement);
	}
}
