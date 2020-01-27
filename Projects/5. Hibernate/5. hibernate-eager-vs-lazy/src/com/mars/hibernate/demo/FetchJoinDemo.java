package com.mars.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

import com.mars.hiibernate.entity.Course;
import com.mars.hiibernate.entity.Instructor;
import com.mars.hiibernate.entity.InstructorDetail;

public class FetchJoinDemo {

	public static void main(String[] args) {
		// Create Session Factory

		SessionFactory factory = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Course.class)
				.addAnnotatedClass(Instructor.class).addAnnotatedClass(InstructorDetail.class).buildSessionFactory();

		// Create Session
		Session session = factory.getCurrentSession();
		Instructor tempInstructor = null;
		try {

			// start a transaction
			session.beginTransaction();

			// option 2
			// Hibernate with query HQL

			// get instructor from db

			int myID = 1;

			Query<Instructor> query = session.createQuery(
					"select i from Instructor i " + "JOIN FETCH i.courses " + "WHERE i.id=:theInstructorId",
					Instructor.class);

			// setParameter on query
			query.setParameter("theInstructorId", myID);

			// execute query and get the parameter
			tempInstructor = query.getSingleResult();

			// print the instructor detail ///Eager loading
			System.out.println("Current Instructor detail : " + tempInstructor);

			// commit transaction
			session.getTransaction().commit();

			System.out.println("Done!");
		} finally {
			session.close();
			factory.close();
			System.out.println("Current Instructor detail : " + tempInstructor.getCourses());
		}

	}
}
