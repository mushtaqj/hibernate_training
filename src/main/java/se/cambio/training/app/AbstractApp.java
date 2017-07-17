package se.cambio.training.app;

import org.hibernate.Session;

import se.cambio.training.entities.AbstractEntity;
import se.cambio.training.util.HibernateUtil;

/**
 * @author MJameel
 * @since on 7/17/2017.
 */
public abstract class AbstractApp
{
	private final HibernateUtil hibernateUtil;

	public AbstractApp(final String configFile) {
		this.hibernateUtil = HibernateUtil.getInstance(configFile);
	}

	Session getCurrentSession()
	{
		return hibernateUtil.getCurrentSession();
	}

	Session openSession()
	{
		return hibernateUtil.openSession();
	}

	void persist(AbstractEntity entity)
	{
		getCurrentSession().save(entity);
	}

	void delete(AbstractEntity entity)
	{
		getCurrentSession().update(entity);
	}

}
