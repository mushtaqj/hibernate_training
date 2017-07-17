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
	private final String CONFIG_FILE;

	//XML based configuration
	private SessionFactory sessionFactory;

	private HibernateUtil(String configFile)
	{
		this.CONFIG_FILE = configFile;
		this.sessionFactory = buildSessionFactory();
	}

	public static HibernateUtil getInstance(String configFile)
	{
		return new HibernateUtil(configFile);
	}

	public Session getCurrentSession() {

		if (sessionFactory != null && sessionFactory.isOpen())
		{
			return sessionFactory.getCurrentSession();
		}

		throw new IllegalStateException("Session factory not initialized or is closed");
	}

	public Session openSession() {

		if (sessionFactory != null && sessionFactory.isOpen())
		{
			return sessionFactory.openSession();
		}

		throw new IllegalStateException("Session factory not initialized or is closed");
	}

	@Deprecated
	private SessionFactory buildSessionFactoryDeprecated()
	{
		try
		{
			Configuration configuration = new Configuration();
			configuration.configure(CONFIG_FILE);

			return configuration.buildSessionFactory();
		} catch (Exception ex)
		{
			throw new ExceptionInInitializerError(ex);
		}
	}

	private SessionFactory buildSessionFactory()
	{
		final StandardServiceRegistry registry = new StandardServiceRegistryBuilder().configure(CONFIG_FILE).build();
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
}
