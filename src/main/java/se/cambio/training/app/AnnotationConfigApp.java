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

	public static void main(final String[] args) throws Exception
	{
		AnnotationConfigApp app = new AnnotationConfigApp("hibernate.annotated.cfg.xml");

		//Begin the transaction
		Session session = app.getCurrentSession();
		session.beginTransaction();

//				SparePart sparePart = new SparePart("Toyota head lights","Toyota lights for Honet Motor bike 2015");
//				sparePart.setCategory(app.load(Category.class,3));
//				sparePart.setManufacturer(app.load(Manufacturer.class,2));

//		SparePart sparePart = app.load(SparePart.class, 1);
//		sparePart.setCategory(app.load(Category.class, 3));
//
//		app.update(sparePart);

		Category category = app.load(Category.class,3);
		for (SparePart sparePart : category.getSpareParts())
		{
			System.out.println(sparePart);
		}


		//commit the transactions
		session.getTransaction().commit();
		session.close();
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