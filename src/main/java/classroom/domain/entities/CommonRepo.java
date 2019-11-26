package classroom.domain.entities;

import classroom.dal.entities.BaseEntity;

import java.util.List;

public interface CommonRepo
{
	<T extends BaseEntity> T add(BaseEntity entity) throws Exception;

	<T extends BaseEntity> T edit(BaseEntity entity) throws Exception;

	void delete(BaseEntity entity) throws Exception;

	<T extends BaseEntity> T find(BaseEntity entity) throws Exception;

	<T extends BaseEntity> List<T> findAll(BaseEntity entity) throws Exception;
}
