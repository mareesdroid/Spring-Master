package com.mars.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.mars.hiibernate.entity.Course;
import com.mars.hiibernate.entity.Instructor;
import com.mars.hiibernate.entity.InstructorDetail;
import com.mars.hiibernate.entity.Review;

public class CreateCourseAndReviewsDemo {

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
			Course tempCourse = new Course("Kamehame - Beginner to master");
			// add some reviews
			tempCourse.addReview(new Review("I learned Kamehame within 2 mnth great Instructor"));
			tempCourse.addReview(new Review("Kararot for a reason :)"));
			tempCourse.addReview(new Review("I Completed Kamehame Waiting for Instant Transmission Course"));

			// save the course... and leverage the cascade all
			System.out.println("saving the courses : \n" + tempCourse);
			System.out.println("saving the courses : \n" + tempCourse.getReview());

			System.out.println();
			session.save(tempCourse);

			session.getTransaction().commit();

			System.out.println("Done!");
		} finally {
			session.close();
			factory.close();
		}
	}
}
