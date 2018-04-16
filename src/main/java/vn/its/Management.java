package vn.its;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;

import vn.its.model.Course;

public class Management {

	public static void main(String[] args) {
		Course course = new Course(2, "Hibernate");

		Configuration configuration = new Configuration();
		configuration.configure();
		
		ServiceRegistry registry = new StandardServiceRegistryBuilder().applySettings(configuration.getProperties()).build();
		SessionFactory sessionFactory = configuration.buildSessionFactory(registry);
		Session session = sessionFactory.openSession();
		session.beginTransaction();
		session.save(course);
		session.getTransaction().commit();
		sessionFactory.close();
		
	}

}
