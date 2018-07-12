package se.cambio.training.app;

import java.util.List;

import org.hibernate.Session;

import se.cambio.training.entities.Category;
import se.cambio.training.entities.Manufacturer;
import se.cambio.training.factories.CategoryInventoryControl;
import se.cambio.training.factories.InventoryControl;
import se.cambio.training.factories.ManufacturerInventoryControl;
import se.cambio.training.uow.CreateInvoiceUnitOfWork;
import se.cambio.training.uow.CreateNewSparePartUnitOfWork;
import se.cambio.training.uow.CreateNewSparePartUnitOfWorkWithoutCascade;
import se.cambio.training.uow.UpdateInvoiceUnitOfWork;

/**
 * @author MJameel
 * @since on 7/17/2017.
 */
public class AnnotationConfigApp
{

	public static void main(final String[] args)
	{
		final HibernateManager manager = new HibernateManager("hibernate.annotated.cfg.xml");

		//Begin the transaction
		Session session = manager.getCurrentSession();
		session.beginTransaction();

		new UpdateInvoiceUnitOfWork(manager).execute();

		//commit the transactions
		session.getTransaction().commit();
		session.close();

	}

	private static void persistCoreData(final HibernateManager app)
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