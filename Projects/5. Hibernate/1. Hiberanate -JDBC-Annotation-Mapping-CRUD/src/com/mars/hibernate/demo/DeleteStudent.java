package com.mars.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.mars.hiibernate.entity.Student;

public class DeleteStudent {

	public static void main(String[] args) {
		// Create Session Factory

		int studentId = 5;

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
			// Approach 1
			Student myStudent = session.get(Student.class, studentId);

			System.out.println("deleting " + myStudent);

			session.delete(myStudent);

			// Approach 2

			session.createQuery("delete from Student where id = 6").executeUpdate();

			session.getTransaction().commit();

			System.out.println("Done!");

		} finally {
			factory.close();
		}
	}

}
