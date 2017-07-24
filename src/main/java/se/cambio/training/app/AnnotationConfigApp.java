package se.cambio.training.app;

import org.hibernate.Session;

import se.cambio.training.entities.Invoice;
import se.cambio.training.entities.SparePart;

/**
 * @author MJameel
 * @since on 7/17/2017.
 */
public class AnnotationConfigApp extends AbstractApp
{

    public AnnotationConfigApp(String configFile) {
        super(configFile);
    }

    public static void main(final String[] args) throws Exception
    {
        AnnotationConfigApp app = new AnnotationConfigApp("hibernate.annotated.cfg.xml");

        //Begin the transaction
        Session session = app.getCurrentSession();
        session.beginTransaction();

        Invoice invoice = app.get(Invoice.class, 2);
        SparePart sparePart = app.load(SparePart.class, 6);

        invoice.getSpareParts().remove(sparePart);

        app.update(invoice);

        //commit the transactions
        session.getTransaction().commit();
        session.close();
    }
}