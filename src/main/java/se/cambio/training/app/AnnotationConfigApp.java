package se.cambio.training.app;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
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

		Category category09 = app.load(Category.class,9);
		Category category08 = app.load(Category.class,8);
		SparePart sparePart01 = app.load(SparePart.class,1);
		SparePart sparePart02 = app.load(SparePart.class,2);

		final ArrayList<SparePart> spareParts = new ArrayList<SparePart>(category09.getSpareParts());
		spareParts.remove(sparePart01);

		category09.setSpareParts(spareParts);
		sparePart01.setCategory(null);

		final ArrayList<SparePart> spareParts02 = new ArrayList<SparePart>(category08.getSpareParts());
		spareParts02.add(sparePart01);

		category08.setSpareParts(spareParts02);
		sparePart01.setCategory(category08);

		app.persist(category08);
		app.update(sparePart01);
		app.persist(category09);
		app.update(sparePart02);

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