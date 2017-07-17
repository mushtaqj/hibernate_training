package se.cambio.training.entities.annotated;

import java.util.Date;
import java.util.List;

/**
 * @author MJameel
 * @since on 7/17/2017.
 */
public class Invoice extends AbstractEntity
{
	/**
	 * name will be used to store customer name
	 */
	private Date date;
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
