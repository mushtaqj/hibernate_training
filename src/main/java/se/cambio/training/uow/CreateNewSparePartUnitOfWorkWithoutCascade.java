package se.cambio.training.uow;

import se.cambio.training.app.HibernateManager;
import se.cambio.training.entities.Category;
import se.cambio.training.entities.Manufacturer;
import se.cambio.training.entities.SparePart;

/**
 * Creates a new Spare Part with new manufacturer and new category
 * disable casscades in the entity
 */
public class CreateNewSparePartUnitOfWorkWithoutCascade extends UnitOfWork {

    public CreateNewSparePartUnitOfWorkWithoutCascade(final HibernateManager hibernateManager) {
        super(hibernateManager);
    }

    @Override
    public void execute() {

        final SparePart hondaWheel = new SparePart();
        final Category tyres = new Category("Tyre","Tyres");
        hibernateManager.persist(tyres);
        hondaWheel.setName("18' Tyre Honda Bike");
        hondaWheel.setCategory(tyres);
        hondaWheel.setManufacturer(hibernateManager.load(Manufacturer.class,1));

        hibernateManager.persist(hondaWheel);
    }
}
