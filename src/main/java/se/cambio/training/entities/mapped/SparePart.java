package se.cambio.training.entities.mapped;

/**
 * @author MJameel
 * @since on 7/17/2017.
 */
public class SparePart extends AbstractEntity
{
	private Category category;
	private Manufacturer manufacturer;
	private String description;

	public Category getCategory()
	{
		return category;
	}

	public void setCategory(Category category)
	{
		this.category = category;
	}

	public Manufacturer getManufacturer()
	{
		return manufacturer;
	}

	public void setManufacturer(Manufacturer manufacturer)
	{
		this.manufacturer = manufacturer;
	}

	public String getDescription()
	{
		return description;
	}

	public void setDescription(String description)
	{
		this.description = description;
	}
}
