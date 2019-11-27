package classroom.domain.entities;

import classroom.dal.entities.BaseEntity;

import java.util.List;

public interface CommonRepo
{
	<T extends BaseEntity> T add(BaseEntity entity) throws Exception;

	<T extends BaseEntity> T edit(BaseEntity entity) throws Exception;

	<T extends BaseEntity> void delete(BaseEntity entity) throws Exception;

	<T extends BaseEntity> T find(Class<T> klass, Long id) throws Exception;

	<T extends BaseEntity> List findAll(BaseEntity entity) throws Exception;
}
