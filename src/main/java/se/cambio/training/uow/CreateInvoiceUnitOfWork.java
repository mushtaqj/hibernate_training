package se.cambio.training.uow;

import se.cambio.training.app.HibernateManager;
import se.cambio.training.entities.Invoice;
import se.cambio.training.entities.SparePart;

import java.util.Arrays;
import java.util.Date;

public class CreateInvoiceUnitOfWork extends UnitOfWork {

    public CreateInvoiceUnitOfWork(HibernateManager hibernateManager) {
        super(hibernateManager);
    }

    @Override
    public void execute() {
        final Invoice invoice = new Invoice();
        invoice.setDate(new Date());
        invoice.setName("Mr. John Doe");

        final SparePart hondaWheel18Inch = hibernateManager.load(SparePart.class,1);
        final SparePart hondaWheel20Inch = hibernateManager.load(SparePart.class,3);

        invoice.setSpareParts(Arrays.asList(hondaWheel18Inch,hondaWheel20Inch));

        hibernateManager.persist(invoice);


    }
}
