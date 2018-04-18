package vn.its;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import vn.its.model.Address;
import vn.its.model.Course;
import vn.its.model.Fresher;
import vn.its.model.Group;
import vn.its.model.Syllabus;

public class Management {

	public static void main(String[] args) {
		// createCourseSyllabuses();
		// getCourseSyllabuses(1);
		// createFresherAndAddress();
		// createFresherAndCourse();
		// createFresherAndGroup();
		createGroup();
		getGroup();
		ConnectionUtil.getSessionFactory().close();

	}

	private static void getGroup() {
		SessionFactory sessionFactory = ConnectionUtil.getSessionFactory();

		try {
			Session session = sessionFactory.openSession();
			session.beginTransaction();
			Group group = (Group) session.get(Group.class, 1);
			System.out.println(group);
			group.setName("New Java Group");
			session.update(group);
			System.out.println(group);
			session.delete(group);
			session.getTransaction().commit();
		} catch (Exception e) {
			System.out.println(e.toString());
		}
	}

	private static void createGroup() {
		SessionFactory sessionFactory = ConnectionUtil.getSessionFactory();

		try {
			Session session = sessionFactory.openSession();
			session.beginTransaction();
			Group group1 = new Group("Java");
			Group group2 = new Group("JavaScript");
			session.save(group1);
			session.save(group2);
			session.getTransaction().commit();
		} catch (Exception e) {
			System.out.println(e.toString());
		}
	}

	private static void createFresherAndGroup() {
		Fresher fresher1 = new Fresher();
		Fresher fresher2 = new Fresher();
		Group group1 = new Group();
		Group group2 = new Group();
		Set<Fresher> freshers = new HashSet<Fresher>();
		freshers.add(fresher1);
		freshers.add(fresher2);
		Set<Group> groups = new HashSet<Group>();
		groups.add(group1);
		groups.add(group2);

		fresher1.setName("Fresher 1");
		fresher2.setName("Fresher 2");
		fresher1.setGroups(groups);
		fresher2.setGroups(groups);

		group1.setFreshers(freshers);
		group2.setFreshers(freshers);

		SessionFactory sessionFactory = ConnectionUtil.getSessionFactory();

		try {
			Session session = sessionFactory.openSession();
			session.beginTransaction();
			session.save(fresher1);
			session.save(fresher2);
			session.save(group1);
			session.save(group2);
			session.getTransaction().commit();
			// Course hibernate = (Course) session.get(Course.class, 2);
			// System.out.println(hibernate);
		} catch (Exception e) {
			System.out.println(e.toString());
		}
	}

	private static void createFresherAndCourse() {
		List<Course> courses = new ArrayList<Course>();
		courses.add(new Course("Hibernate"));
		courses.add(new Course("Java"));
		Fresher fresher = new Fresher("tuan", courses);

		SessionFactory sessionFactory = ConnectionUtil.getSessionFactory();

		try {
			Session session = sessionFactory.openSession();
			session.beginTransaction();
			for (Course course : courses) {
				session.save(course);
			}
			session.save(fresher);
			session.getTransaction().commit();
			// Course hibernate = (Course) session.get(Course.class, 2);
			// System.out.println(hibernate);
		} catch (Exception e) {
			System.out.println(e.toString());
		}
	}

	private static void createFresherAndAddress() {
		Address address = new Address("duy tan", "cau giay");
		Fresher fresher = new Fresher("tuan", address);

		SessionFactory sessionFactory = ConnectionUtil.getSessionFactory();

		try {
			Session session = sessionFactory.openSession();
			session.beginTransaction();
			session.save(address);
			session.save(fresher);
			session.getTransaction().commit();
			// Course hibernate = (Course) session.get(Course.class, 2);
			// System.out.println(hibernate);
		} catch (Exception e) {
			System.out.println(e.toString());
		}
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
