package com.mars.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.mars.hiibernate.entity.Student;

public class UpdateStudent {

	public static void main(String[] args) {
		// Create Session Factory

		int studentId = 1;

		SessionFactory factory = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Student.class)
				.buildSessionFactory();

		// Create Session
		Session session = factory.getCurrentSession();

		try {
			// use the session object to save java object

			// start a transaction
			session.beginTransaction();

			/*
			 * update first name to selected id
			 * 
			 */

			System.out.println("Getting student with id : " + studentId);
			Student myStudent = session.get(Student.class, studentId);

			System.out.println("Updating first name to " + myStudent);

			myStudent.setFirstName("mars");

			/*
			 * update lastname to all
			 * 
			 */
			System.out.println("Update last name to all");

			session.createQuery("update Student	set lastName = 'A'").executeUpdate();

			session.getTransaction().commit();

			System.out.println("Done!");

		} finally {
			factory.close();
		}
	}
}
