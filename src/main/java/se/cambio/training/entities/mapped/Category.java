package se.cambio.training.entities.mapped;

import se.cambio.training.entities.AbstractEntity;

/**
 * @author MJameel
 * @since on 7/17/2017.
 */
public class Category extends AbstractEntity
{
	private String description;

	public String getDescription()
	{
		return description;
	}

	public void setDescription(String description)
	{
		this.description = description;
	}
}
