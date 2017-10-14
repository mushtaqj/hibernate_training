package se.cambio.training.entities;

import java.util.List;

import javax.persistence.Basic;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.OneToMany;
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

	@OneToMany
	@JoinTable(joinColumns = {@JoinColumn(name = "category_id") },
		inverseJoinColumns = { @JoinColumn(name = "spare_part_id") })
	private List<SparePart> spareParts;

	public Category()
	{
		//default no-args constructor
	}

	public Category(String name, String description)
	{
		setName(name);
		setDescription(description);
	}

	public String getDescription()
	{
		return description;
	}

	public void setDescription(String description)
	{
		this.description = description;
	}

	public List<SparePart> getSpareParts()
	{
		return spareParts;
	}

	public void setSpareParts(List<SparePart> spareParts)
	{
		this.spareParts = spareParts;
	}
}
