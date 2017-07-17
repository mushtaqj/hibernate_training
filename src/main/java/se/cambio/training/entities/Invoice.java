package se.cambio.training.entities;

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
	private List<Spare> spares;

	public Date getDate()
	{
		return date;
	}

	public void setDate(Date date)
	{
		this.date = date;
	}

	public List<Spare> getSpares()
	{
		return spares;
	}

	public void setSpares(List<Spare> spares)
	{
		this.spares = spares;
	}
}
