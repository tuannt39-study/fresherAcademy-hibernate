package vn.its;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import vn.its.model.Course;
import vn.its.model.Syllabus;

public class Management {

	public static void main(String[] args) {
		createCourseSyllabuses();
		getCourseSyllabuses(1);
		ConnectionUtil.getSessionFactory().close();

	}

	private static void getCourseSyllabuses(int id) {
		SessionFactory sessionFactory = ConnectionUtil.getSessionFactory();
		try {
			Session session = sessionFactory.openSession();
			session.beginTransaction();
			Course course = (Course) session.get(Course.class, id);
			System.out.println(course.getName());
			session.getTransaction().commit();
			session.close();
			System.out.println(course.getSyllabuses());
		} catch (Exception e) {
			System.out.println(e.toString());
		}
	}

	private static void createCourseSyllabuses() {
		List<Syllabus> syllabuses = new ArrayList<Syllabus>();
		syllabuses.add(new Syllabus("Hibernate content", 30));
		syllabuses.add(new Syllabus("Hibernate offline content", 50));
		Course course = new Course("@Id Hibernate", new Date(), syllabuses);

		SessionFactory sessionFactory = ConnectionUtil.getSessionFactory();

		try {
			Session session = sessionFactory.openSession();
			session.beginTransaction();
			session.save(course);
			session.getTransaction().commit();
			// Course hibernate = (Course) session.get(Course.class, 2);
			// System.out.println(hibernate);
		} catch (Exception e) {
			System.out.println(e.toString());
		}
	}

}
