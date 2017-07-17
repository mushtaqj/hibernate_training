package se.cambio.training;

import org.hibernate.Session;

import se.cambio.training.entities.AbstractEntity;
import se.cambio.training.util.HibernateUtil;

/**
 * @author MJameel
 * @since on 7/17/2017.
 */
public abstract class AbstractApp
{
	Session getCurrentSession()
	{
		return HibernateUtil.getCurrentSession();
	}

	Session openSession()
	{
		return HibernateUtil.openSession();
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
