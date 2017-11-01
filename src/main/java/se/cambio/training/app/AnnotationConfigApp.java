package se.cambio.training.app;

import static se.cambio.training.util.EntityDataOperations.deleteCategoryAndManufacturer;
import static se.cambio.training.util.EntityDataOperations.loadSparePart;

import org.hibernate.Session;

import se.cambio.training.entities.Category;
import se.cambio.training.entities.SparePart;

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

		deleteCategoryAndManufacturer(app);

		//commit the transactions
		session.getTransaction().commit();
//		session.close();
	}

	private static void setCategoryToNull(AnnotationConfigApp app)
	{
		final SparePart sparePart = loadSparePart(app, 1);
		sparePart.setCategory(null);
		app.persist(sparePart);
	}

}