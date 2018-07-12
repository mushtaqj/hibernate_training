package se.cambio.training.uow;

import se.cambio.training.app.HibernateManager;
import se.cambio.training.entities.Invoice;
import se.cambio.training.entities.SparePart;

import java.util.Arrays;
import java.util.Date;

public class UpdateInvoiceUnitOfWork extends UnitOfWork {

    public UpdateInvoiceUnitOfWork(HibernateManager hibernateManager) {
        super(hibernateManager);
    }

    @Override
    public void execute() {
        final Invoice invoice = hibernateManager.get(Invoice.class, 2);
//        final SparePart inchWheel20 = hibernateManager.load(SparePart.class, 3);
        invoice.setDate(new Date());
        invoice.getSpareParts().remove(1);

        hibernateManager.persist(invoice);


    }
}
