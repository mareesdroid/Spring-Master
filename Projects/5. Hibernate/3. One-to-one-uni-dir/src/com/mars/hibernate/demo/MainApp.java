package com.mars.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.mars.hiibernate.entity.Instructor;
import com.mars.hiibernate.entity.InstructorDetail;

public class MainApp {
	public static void main(String[] args) {

		// Create Session Factory

		SessionFactory factory = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Instructor.class)
				.addAnnotatedClass(InstructorDetail.class).buildSessionFactory();

		// Create Session
		Session session = factory.getCurrentSession();

		try {
			// create the objects

			Instructor tempInstructor = new Instructor("theGuru", "Z", "reachMaster@dbz.com");

			InstructorDetail tempInstructorDetail = new InstructorDetail("https://youtube.com/dbz_warrior", "Swimming");

			// associate the objects
			tempInstructor.setInstructorDetail(tempInstructorDetail);
			// start a transaction
			session.beginTransaction();
			// save the instructor
			/*
			 * Note: This will Also save the detail object because of CascadeType.ALL
			 */
			System.out.println("Saving Instructor : \n" + tempInstructor);

			session.save(tempInstructor);

			// commit transaction
			session.getTransaction().commit();

			System.out.println("Done!");
		} finally {
			factory.close();
		}
	}
}
