package com.mars.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.mars.hiibernate.entity.Student;

public class CreateStudent {
	public static void main(String[] args) {

		// Create Session Factory

		SessionFactory factory = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Student.class)
				.buildSessionFactory();

		// Create Session
		Session session = factory.getCurrentSession();

		try {
			// use the session object to save java object

			// create a student object
			System.out.println("Creating a new student");
			Student tempStudent = new Student("Marees", "waran", "mareesdroid@gmail.com");
			// start a transaction
			session.beginTransaction();
			// save the student object
			System.out.println("Saving a Student");
			session.save(tempStudent);
			// commit transaction
			session.getTransaction().commit();

			System.out.println("Done!");
		} finally {
			factory.close();
		}
	}
}
