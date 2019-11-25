package classroom.domain.entities;

import java.util.List;

public interface CommonRepo
{
	<T> T add(Class<T> obj) throws Exception;

	<T> T edit(Class<T> obj) throws Exception;

	<T> void delete(Class<T> obj) throws Exception;

	<T> T find(Class<T> obj) throws Exception;

	<T> List<T> findAll(Class<T> obj) throws Exception;
}
