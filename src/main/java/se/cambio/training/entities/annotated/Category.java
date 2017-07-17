package se.cambio.training.entities.annotated;

import se.cambio.training.entities.AbstractEntity;

import javax.persistence.Basic;
import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * @author MJameel
 * @since on 7/17/2017.
 */
@Entity
@Table(name = "CATEGORIES")
public class Category extends AbstractEntity
{
	@Basic
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
