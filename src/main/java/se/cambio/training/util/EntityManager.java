package se.cambio.training.util;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.Metadata;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;

/**
 * Encapsulate Hibernate SessionFactory
 *
 * @author MJameel
 * @since on 7/17/2017.
 */
public class EntityManager
{
	private final String CONFIG_FILE;

	//XML based configuration
	private final SessionFactory sessionFactory;
	private static EntityManager instance;

	private EntityManager(String configFile)
	{
		this.CONFIG_FILE = configFile;
		sessionFactory = buildSessionFactory();
	}

	public static EntityManager getInstance(String configFile)
	{
		if (instance == null)
		{
			instance = new EntityManager(configFile);
		}

		return instance;
	}

	public Session getCurrentSession()
	{

		if (sessionFactory != null)
		{
			return sessionFactory.getCurrentSession();
		}

		throw new IllegalStateException("Session factory not initialized or is closed");
	}

	public Session openSession()
	{

		if (sessionFactory != null)
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
			ex.printStackTrace();
			// The registry would be destroyed by the SessionFactory, but we had trouble building the SessionFactory
			// so destroy it manually.
			StandardServiceRegistryBuilder.destroy(registry);
			throw new ExceptionInInitializerError(ex);
		}
	}
}
