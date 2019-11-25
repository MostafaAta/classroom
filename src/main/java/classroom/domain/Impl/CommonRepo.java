package classroom.domain.Impl;

import classroom.domain.entities.ClassroomDelegator;

import java.util.List;

public class CommonRepo implements ClassroomDelegator
{

	@Override
	public <T> T add(Class<T> obj)
	{
		return null;
	}

	@Override
	public <T> T edit(Class<T> obj)
	{
		return null;
	}

	@Override
	public <T> void delete(Class<T> obj)
	{

	}

	@Override
	public <T> T find(Class<T> obj)
	{
		return null;
	}

	@Override
	public <T> List<T> findAll(Class<T> obj)
	{
		return null;
	}
}
