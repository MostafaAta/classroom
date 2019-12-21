package classroom.domain.entities;

import classroom.dal.roots.Persistable;
import classroom.domain.common.*;

import java.util.List;

public interface CommonRepo<T extends Persistable>
{
	T add(T entity) throws Throwable;

	T edit(T entity) throws Throwable;

	void delete(T entity) throws Throwable;

	T find(Class<? extends Persistable> klass, Long id) throws Throwable;

	T find(String classType, Long id) throws Throwable;

	List<T> findAll(Class<? extends Persistable> klass) throws Throwable;

	List<T> findByCriteria(Class<? extends Persistable> klass, CriteriaBuilder... statments) throws Throwable;
}
