package se.cambio.training.app;

import org.hibernate.Session;
import se.cambio.training.entities.Category;

/**
 * @author MJameel
 * @since on 7/17/2017.
 */
public class XmlConfigApp
{

    public static void main(final String[] args)
    {
        HibernateManager app = new HibernateManager("hibernate.mapped.cfg.xml");

        //Begin the transaction
        Session session = app.getCurrentSession();
        session.beginTransaction();

        //create object
        Category category = new Category();
        category.setName("Headlights");
        category.setDescription("Headlights for motor vehicles");

        //save object
        app.persist(category);

        //commit the transaction
        session.getTransaction().commit();
        session.close();

        System.exit(0);
    }
}