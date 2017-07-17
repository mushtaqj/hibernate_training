package se.cambio.training.util;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.Metadata;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;

/**
 * @author MJameel
 * @since on 7/17/2017.
 */
public class HibernateUtil
{
	//XML based configuration
	private static SessionFactory sessionFactory;

	static {
		sessionFactory = buildSessionFactory();
	}

	@Deprecated
	private static SessionFactory buildSessionFactoryDeprecated()
	{
		try
		{
			Configuration configuration = new Configuration();
			configuration.configure();

			return configuration.buildSessionFactory();
		} catch (Exception ex)
		{
			throw new ExceptionInInitializerError(ex);
		}
	}

	private static SessionFactory buildSessionFactory()
	{
		final StandardServiceRegistry registry = new StandardServiceRegistryBuilder().configure().build();
		try
		{
			final Metadata metadata = new MetadataSources(registry).buildMetadata();
			return metadata.buildSessionFactory();

		} catch (Exception ex)
		{
			// The registry would be destroyed by the SessionFactory, but we had trouble building the SessionFactory
			// so destroy it manually.
			StandardServiceRegistryBuilder.destroy(registry);
			throw new ExceptionInInitializerError(ex);
		}
	}

	public static Session getCurrentSession() {

		if (sessionFactory != null && sessionFactory.isOpen())
		{
			return sessionFactory.getCurrentSession();
		}

		throw new IllegalStateException("Session factory not initialized or is closed");
	}

	public static Session openSession() {

		if (sessionFactory != null && sessionFactory.isOpen())
		{
			return sessionFactory.openSession();
		}

		throw new IllegalStateException("Session factory not initialized or is closed");
	}
}
