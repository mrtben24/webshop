package mrtben24.sb.webshop.mvc.db;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.query.Query;

import mrtben24.sb.webshop.mvc.model.Product;

public class Database {

	private SessionFactory sessionFactory;

	public Database() {

		StandardServiceRegistry registry = new StandardServiceRegistryBuilder().configure() // configures settings from
																							// hibernate.cfg.xml
				.build();

		sessionFactory = new MetadataSources(registry).buildMetadata().buildSessionFactory();
	}

	
	public List<Product> getAllProduct() {

	List<Product> products = null;

	Session session = sessionFactory.openSession();
	Transaction tr = session.beginTransaction();

	Query query = session.createQuery("SELECT p FROM Product p");
	products = query.getResultList();

	tr.commit();
	session.close();

	return products;
}
	
	
	
	
	/*public Product getProductById(int productId) {

		Product product = null;

		Session session = sessionFactory.openSession();
		Transaction tr = session.beginTransaction();

		product = session.get(Product.class, productId);

		tr.commit();
		session.close();

		return product;
	}*/

	public void closeDb() {

		sessionFactory.close();
	}
}
