package se.cambio.training.factories;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import se.cambio.training.entities.Category;

/**
 * @author MJameel
 * @since on 7/24/2017.
 */
public class CategoryInventoryControl implements InventoryControl<Category>
{
	private final static List<String> CATEGORY_NAMES = Arrays.asList(
		"Wheel","Rims","Lights","Cables","Brakes","Suspension","Seat cover","Horn","Interior decor","floor mats"
	);
	private final static List<String> CATEGORY_DESCRIPTIONS = Arrays.asList(
		"Wheel category","Rims category","Lights category","Cables category","Brakes category","Suspension category",
		"Seat cover category","Horn category","Interior decor category","floor mats category"
	);

	public List<Category> populate()
	{
		List<Category> categories = new ArrayList<Category>();

		for (int i = 0; i < CATEGORY_NAMES.size(); i++)
		{
			categories.add(new Category(CATEGORY_NAMES.get(i),CATEGORY_DESCRIPTIONS.get(i)));
		}

		return categories;
	}

}
