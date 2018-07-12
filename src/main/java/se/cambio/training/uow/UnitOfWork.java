package se.cambio.training.uow;

import se.cambio.training.app.HibernateManager;

public abstract class UnitOfWork {

    final HibernateManager hibernateManager;

    public UnitOfWork(final HibernateManager hibernateManager) {
        this.hibernateManager = hibernateManager;
    }

    public abstract void execute();

}
