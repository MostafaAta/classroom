package classroom.domain.entities;

import classroom.dal.entities.BaseEntity;

import java.util.List;

public interface CommonRepo
{
	<T extends BaseEntity> T add(T entity) throws Exception;

	<T extends BaseEntity> T edit(T entity) throws Exception;

	<T extends BaseEntity> void delete(T entity) throws Exception;

	<T extends BaseEntity> T find(Class<T> klass, Long id) throws Exception;

	<T extends BaseEntity> List findAll(BaseEntity entity) throws Exception;
}
