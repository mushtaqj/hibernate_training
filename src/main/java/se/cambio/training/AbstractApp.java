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
	public Session getCurrentSession()
	{
		return HibernateUtil.getCurrentSession();
	}

	public Session openSession()
	{
		return HibernateUtil.openSession();
	}

	public void persist(AbstractEntity entity)
	{
		getCurrentSession().save(entity);
	}

	public void delete(AbstractEntity entity)
	{
		getCurrentSession().update(entity);
	}



}
