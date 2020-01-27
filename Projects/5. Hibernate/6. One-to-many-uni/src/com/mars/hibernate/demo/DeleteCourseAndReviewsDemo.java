package com.mars.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.mars.hiibernate.entity.Course;
import com.mars.hiibernate.entity.Instructor;
import com.mars.hiibernate.entity.InstructorDetail;
import com.mars.hiibernate.entity.Review;

public class DeleteCourseAndReviewsDemo {

	public static void main(String[] args) {
		// Create Session Factory

		SessionFactory factory = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Instructor.class)
				.addAnnotatedClass(InstructorDetail.class).addAnnotatedClass(Course.class)
				.addAnnotatedClass(Review.class).buildSessionFactory();
		// Create Session

		Session session = factory.getCurrentSession();
		try {
			// strat a transaction
			session.beginTransaction();

			// create a course
			int theId = 10;

			Course tempCourse = session.get(Course.class, theId);

			// print the course

			System.out.println("Deleting Course : \n" + tempCourse);
			session.delete(tempCourse);
			session.getTransaction().commit();

			System.out.println("Done!");
		} finally {
			session.close();
			factory.close();
		}
	}
}
