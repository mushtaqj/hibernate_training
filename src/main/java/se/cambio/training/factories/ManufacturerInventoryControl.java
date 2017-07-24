package se.cambio.training.factories;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import se.cambio.training.entities.Manufacturer;

/**
 * @author MJameel
 * @since on 7/24/2017.
 */
public class ManufacturerInventoryControl implements InventoryControl<Manufacturer>
{
	private final static List<String> MANUFACTURER_NAMES = Arrays.asList(
		"Honda","Toyota","Aston Martin","BMW","Mercedes","Mazda","Suzuki","Proton"
	);
	private final static List<String> MANUFACTURER_REGISTRATION = Arrays.asList(
		"HON-DA-01","TOY-OTA-02","ASTON-MARTIN-03","BMW-04","MERC-EDES-05","MAZDA-06","SUZ-UKI-07","PRO-TON-08"
	);

	public List<Manufacturer> populate()
	{
		List<Manufacturer> categories = new ArrayList<Manufacturer>();

		for (int i = 0; i < MANUFACTURER_NAMES.size(); i++)
		{
			categories.add(new Manufacturer(MANUFACTURER_NAMES.get(i), MANUFACTURER_REGISTRATION.get(i)));
		}

		return categories;
	}

}
