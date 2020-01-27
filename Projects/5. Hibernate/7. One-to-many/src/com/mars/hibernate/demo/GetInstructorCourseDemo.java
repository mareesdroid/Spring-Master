package com.mars.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.mars.hiibernate.entity.Course;
import com.mars.hiibernate.entity.Instructor;
import com.mars.hiibernate.entity.InstructorDetail;

public class GetInstructorCourseDemo {

	public static void main(String[] args) {

		// Create Session Factory

		SessionFactory factory = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Course.class)
				.addAnnotatedClass(Instructor.class).addAnnotatedClass(InstructorDetail.class).buildSessionFactory();

		// Create Session
		Session session = factory.getCurrentSession();

		try {

			// start a transaction
			session.beginTransaction();

			// get instructor detail object

			int myID = 1;

			Instructor instructor = session.get(Instructor.class, myID);

			// print the instructor detail
			System.out.println("Current Instructor detail : " + instructor);
			// print instructor course
			System.out.println("Associated instructor was : " + instructor.getCourses());

			// commit transaction
			session.getTransaction().commit();

			System.out.println("Done!");
		} finally {
			session.close();
			factory.close();
		}
	}

}
