package vn.its;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;

import vn.its.model.Course;

public class Management {

	public static void main(String[] args) {
		// Course course = new Course(4, "Jpa");

		SessionFactory sessionFactory = ConnectionUtil.getSessionFactory();

		try {
			Session session = sessionFactory.openSession();
			session.beginTransaction();
			// session.save(course);
			// session.getTransaction().commit();
			Course hibernate = (Course) session.get(Course.class, 2);
			System.out.println(hibernate);
		} catch (Exception e) {
			System.out.println(e.toString());
		}
		ConnectionUtil.getSessionFactory().close();

	}

}
