package se.cambio.training.entities.mapped;

import se.cambio.training.entities.AbstractEntity;

/**
 * @author MJameel
 * @since on 7/17/2017.
 */
public class Manufacturer extends AbstractEntity
{
	private String registrationNumber;

	public String getRegistrationNumber()
	{
		return registrationNumber;
	}

	public void setRegistrationNumber(String registrationNumber)
	{
		this.registrationNumber = registrationNumber;
	}
}
