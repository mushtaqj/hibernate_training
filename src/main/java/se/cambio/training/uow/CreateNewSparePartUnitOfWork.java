package se.cambio.training.uow;

import se.cambio.training.app.HibernateManager;
import se.cambio.training.entities.Category;
import se.cambio.training.entities.Manufacturer;
import se.cambio.training.entities.SparePart;

/**
 * Creates a new Spare Part with new manufacturer and new category
 */
public class CreateNewSparePartUnitOfWork extends UnitOfWork {

    private final HibernateManager hibernateManager;

    public CreateNewSparePartUnitOfWork(final HibernateManager hibernateManager) {
        this.hibernateManager = hibernateManager;
    }

    @Override
    public void execute() {

        final SparePart hondaWheel = new SparePart();
        final Category tyres = new Category("Tyre","Tyres");
        hondaWheel.setName("18' Tyre Honda Bike");
        hondaWheel.setCategory(tyres);
        hondaWheel.setManufacturer(hibernateManager.load(Manufacturer.class,1));

        hibernateManager.persist(hondaWheel);
    }
}
