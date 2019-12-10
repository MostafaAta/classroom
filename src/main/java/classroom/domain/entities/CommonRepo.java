package classroom.domain.entities;

import classroom.dal.roots.*;

import java.util.List;

public interface CommonRepo<T extends BaseEntity>
{
	 T add(T entity) throws Throwable;

	 T edit(T entity) throws Throwable;

	 void delete(T entity) throws Throwable;

	 T find(Class<? extends Persistable> klass, Long id) throws Throwable;

	 T find(String classType, Long id) throws Throwable;

	 List<T> findAll(Class<? extends Persistable> klass) throws Throwable;
}
