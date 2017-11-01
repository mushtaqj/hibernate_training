package se.cambio.training.util;

import java.util.List;

import se.cambio.training.app.AnnotationConfigApp;
import se.cambio.training.entities.Category;
import se.cambio.training.entities.Manufacturer;
import se.cambio.training.entities.SparePart;
import se.cambio.training.factories.CategoryInventoryControl;
import se.cambio.training.factories.InventoryControl;
import se.cambio.training.factories.ManufacturerInventoryControl;

/**
 * @author MJameel
 * @since on 11/1/2017.
 */
public class EntityDataOperations
{

	public static void deleteCategoryAndManufacturer(AnnotationConfigApp app)
	{
//		final Category category = loadCategory(app, 1);
		final Manufacturer manufacturer = loadManufacturer(app, 1);
//		app.delete(category);
		app.delete(manufacturer);
	}

	public static void loadAndPrintCatsAndManufacturers(AnnotationConfigApp app)
	{
		final Category category = loadCategory(app, 1);
		final Manufacturer manufacturer = loadManufacturer(app, 1);

		System.out.println("Category : " + category);
		category.getSpareParts().forEach(System.out::println);

		System.out.println("Manufacturer : " + manufacturer);
		manufacturer.getSpareParts().forEach(System.out::println);
	}

	public static void persistWheelsAndRims(AnnotationConfigApp app)
	{
		final Category wheels = loadCategory(app, 1);
		final Category Rims = loadCategory(app, 2);

		final Manufacturer honda = loadManufacturer(app, 1);
		final Manufacturer suzuki = loadManufacturer(app,7);

		SparePart hondaWheels = new SparePart();
		hondaWheels.setCategory(wheels);
		hondaWheels.setManufacturer(honda);
		hondaWheels.setDescription("Honda Wheels for Motorbike");
		hondaWheels.setName("Honda Wheels");

		SparePart suzukiWheels = new SparePart();
		suzukiWheels.setCategory(wheels);
		suzukiWheels.setManufacturer(suzuki);
		suzukiWheels.setDescription("Suzuki Wheels for Motorbike");
		suzukiWheels.setName("Suzuki Wheels");


		SparePart hondaRims = new SparePart();
		hondaRims.setCategory(Rims);
		hondaRims.setManufacturer(honda);
		hondaRims.setDescription("Honda Rims for Motorbike");
		hondaRims.setName("Honda Rims");

		SparePart suzukiRims = new SparePart();
		suzukiRims.setCategory(Rims);
		suzukiRims.setManufacturer(suzuki);
		suzukiRims.setDescription("Suzuki Rims for Motorbike");
		suzukiRims.setName("Suzuki Rims");


		app.persist(suzukiWheels);
		app.persist(suzukiRims);
		app.persist(hondaWheels);
		app.persist(hondaRims);
	}

	public static SparePart loadSparePart(AnnotationConfigApp app, int id)
	{
		return app.load(SparePart.class, id);
	}


	public static Category loadCategory(AnnotationConfigApp app, int id)
	{
		return app.load(Category.class, id);
	}

	public static Manufacturer loadManufacturer(AnnotationConfigApp app, int id)
	{
		return app.load(Manufacturer.class, id);
	}

	public static List<Category> generateCategories()
	{
		InventoryControl<Category> categories = new CategoryInventoryControl();
		return categories.populate();
	}

	public static List<Manufacturer> generateManufacturers()
	{
		InventoryControl<Manufacturer> manufacturers = new ManufacturerInventoryControl();
		return manufacturers.populate();
	}
}
