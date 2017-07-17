package se.cambio.training.entities.annotated;

/**
 * @author MJameel
 * @since on 7/17/2017.
 */
public abstract class AbstractEntity
{
	private long id;
	private String name;

	public long getId()
	{
		return id;
	}

	public void setId(long id)
	{
		this.id = id;
	}

	public String getName()
	{
		return name;
	}

	public void setName(String name)
	{
		this.name = name;
	}

	@Override
	public String toString()
	{
		return getClass().getName() +
			": {" +
				"id=" + id +", " +
				"name='" + name + '\'' +
			'}';
	}
}
