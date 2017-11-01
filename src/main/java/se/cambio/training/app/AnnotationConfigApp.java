package se.cambio.training.app;

import java.util.List;

import org.hibernate.Session;

import se.cambio.training.entities.Category;
import se.cambio.training.entities.Manufacturer;
import se.cambio.training.entities.SparePart;
import se.cambio.training.factories.CategoryInventoryControl;
import se.cambio.training.factories.InventoryControl;
import se.cambio.training.factories.ManufacturerInventoryControl;

/**
 * @author MJameel
 * @since on 7/17/2017.
 */
public class AnnotationConfigApp extends AbstractApp
{

	public AnnotationConfigApp(String configFile)
	{
		super(configFile);
	}

	public static void main(final String[] args) throws Exception
	{
		AnnotationConfigApp app = new AnnotationConfigApp("hibernate.annotated.cfg.xml");

		//Begin the transaction
		final Session session = app.getCurrentSession();
		session.beginTransaction();

		final Category category = loadCategory(app, 1);

		System.out.println(category);
		System.out.println(category.getSpareParts());

//		persistWheelsAndRims(app);

		//commit the transactions
		session.getTransaction().commit();
		session.close();
	}

	private static void persistWheelsAndRims(AnnotationConfigApp app)
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

	private static Category loadCategory(AnnotationConfigApp app, int id)
	{
		return app.load(Category.class, id);
	}

	private static Manufacturer loadManufacturer(AnnotationConfigApp app, int id)
	{
		return app.load(Manufacturer.class, id);
	}

	private static List<Category> generateCategories()
	{
		InventoryControl<Category> categories = new CategoryInventoryControl();
		return categories.populate();
	}

	private static List<Manufacturer> generateManufacturers()
	{
		InventoryControl<Manufacturer> manufacturers = new ManufacturerInventoryControl();
		return manufacturers.populate();
	}
}