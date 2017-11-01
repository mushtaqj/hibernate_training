package se.cambio.training.entities;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;

/**
 * @author MJameel
 * @since on 7/17/2017.
 */
@MappedSuperclass
public abstract class AbstractEntity
{
	@Id
	@GeneratedValue(generator = "increment")
	@GenericGenerator(name = "increment",strategy = "increment")
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

	@Basic
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
