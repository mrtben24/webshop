package mrtben24.sb.webshop.mvc.db;

import org.hibernate.SessionFactory;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

public class Database {

	private SessionFactory sessionFactory;

	public Database() {

		StandardServiceRegistry registry = new StandardServiceRegistryBuilder().configure() // configures settings from
																							// hibernate.cfg.xml
				.build();

		sessionFactory = new MetadataSources(registry).buildMetadata().buildSessionFactory();
	}

	
	
	public void closeDb() {
		
		sessionFactory.close();
	}
}
