package se.cambio.training.app;

import java.util.List;

import org.hibernate.Session;

import se.cambio.training.entities.Category;
import se.cambio.training.entities.Invoice;
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

	public static void main(final String[] args)
	{
		AnnotationConfigApp app = new AnnotationConfigApp("hibernate.annotated.cfg.xml");

		//Begin the transaction
		Session session = app.getCurrentSession();
		session.beginTransaction();

        persistCoreData(app);

		//commit the transactions
		session.getTransaction().commit();
		session.close();
	}

	private static void persistCoreData(final AnnotationConfigApp app)
	{
		generateCategories().forEach(app::persist);
		generateManufacturers().forEach(app::persist);
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