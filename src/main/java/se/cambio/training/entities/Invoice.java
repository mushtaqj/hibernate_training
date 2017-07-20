package se.cambio.training.entities;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

/**
 * @author MJameel
 * @since on 7/17/2017.
 */
@Entity
@Table(name = "INVOICES")
public class Invoice extends AbstractEntity
{
	/**
	 * name will be used to store customer name
	 */
	@Temporal(TemporalType.DATE)
	private Date date;
	@ManyToMany(cascade = {CascadeType.PERSIST,CascadeType.MERGE,CascadeType.REMOVE})
	private List<SparePart> spareParts;

	public Date getDate()
	{
		return date;
	}

	public void setDate(Date date)
	{
		this.date = date;
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
