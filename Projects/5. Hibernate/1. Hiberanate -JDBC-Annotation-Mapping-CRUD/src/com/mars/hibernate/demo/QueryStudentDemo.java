package com.mars.hibernate.demo;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.mars.hiibernate.entity.Student;

public class QueryStudentDemo {

	public static void main(String[] args) {
		// Create Session Factory

		SessionFactory factory = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Student.class)
				.buildSessionFactory();

		// Create Session
		Session session = factory.getCurrentSession();

		try {
			// use the session object to save java object

			// start a transaction
			session.beginTransaction();

			// query students
			/*
			 * Select * from table
			 */
			System.out.println("All Students \n");
			List<Student> myResult = session.createQuery("from Student").getResultList();

			daisplayStudents(myResult);

			/*
			 * Select * from table where column name = "fhgjjgljs" USE JAVA PROPERTY NAME
			 * FOR TABLE AND COLUMN
			 * 
			 */
			System.out.println("Students with last name \"waran\": \n");
			myResult = session.createQuery("from Student s where s.lastName = 'waran'").getResultList();

			daisplayStudents(myResult);

			/*
			 * Select * from table where column name = "fhgjjgljs" OR column name =
			 * "adjhasjk" USE JAVA PROPERTY NAME FOR TABLE AND COLUMN
			 * 
			 */
			System.out.println("Students with last name \" waran \" or first name \" yuva \" \n");
			myResult = session.createQuery("from Student s where s.lastName = 'waran' OR s.firstName = 'yuv'")
					.getResultList();

			daisplayStudents(myResult);

			/*
			 * Select * from table where column name like "fjlkj" USE JAVA PROPERTY NAME FOR
			 * TABLE AND COLUMN
			 * 
			 */

			System.out.println("Students Whose with mail like \"@dbz.com\" \n");
			myResult = session.createQuery("from Student s where" + " s.email LIKE '%@dbz.com'").getResultList();

			daisplayStudents(myResult);

			session.getTransaction().commit();

			System.out.println("Done!");

		} finally {
			factory.close();
		}
	}

	private static void daisplayStudents(List<Student> myResult) {
		// TODO Auto-generated method stub

		for (Student curStudent : myResult) {
			System.out.println(curStudent);
		}
	}

}
