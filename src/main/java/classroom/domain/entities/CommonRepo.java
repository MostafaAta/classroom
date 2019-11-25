package classroom.domain.entities;

import java.util.List;

public interface CommonRepo
{
	<T> T add(T obj) throws Exception;

	<T> T edit(T obj) throws Exception;

	<T> void delete(T obj) throws Exception;

	<T> T find(T obj) throws Exception;

	<T> List<T> findAll(T obj) throws Exception;
}
