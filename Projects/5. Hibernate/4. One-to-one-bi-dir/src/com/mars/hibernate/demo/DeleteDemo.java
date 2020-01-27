package com.mars.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.mars.hiibernate.entity.Instructor;
import com.mars.hiibernate.entity.InstructorDetail;

public class DeleteDemo {

	public static void main(String[] args) {

		// Create Session Factory

		SessionFactory factory = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Instructor.class)
				.addAnnotatedClass(InstructorDetail.class).buildSessionFactory();

		// Create Session
		Session session = factory.getCurrentSession();

		try {

			// start a transaction
			session.beginTransaction();

			// get instructor by primary key/id

			int theId = 1;
			Instructor tempInstructor = session.get(Instructor.class, theId);

			// System.out.println("Found instructor: " + tempInstructor);
			// delete the instructor

			if (tempInstructor != null) {
				// delete the instructor
				System.out.println("Deleting: " + tempInstructor);
				/*
				 * Note: This will Also delete the detail object because of CascadeType.ALL
				 */
				session.delete(tempInstructor);
			}

			// commit transaction
			session.getTransaction().commit();

			System.out.println("Done!");
		} finally {
			factory.close();
		}
	}

}
