package com.mars.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.mars.hiibernate.entity.Course;
import com.mars.hiibernate.entity.Instructor;
import com.mars.hiibernate.entity.InstructorDetail;

public class DeleteCourseDemo {

	public static void main(String[] args) {
		// Create Session Factory

		SessionFactory factory = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Instructor.class)
				.addAnnotatedClass(InstructorDetail.class).addAnnotatedClass(Course.class).buildSessionFactory();
		// Create Session

		Session session = factory.getCurrentSession();
		try {

			session.beginTransaction();

			// get the instructor from db

			int theId = 45; // courseid

			Course tempCourse = session.get(Course.class, theId);
			if (null == tempCourse) {
				System.out.println("null :(");
			}
			System.out.println(tempCourse);

			// delete course
			session.delete(tempCourse);

			session.getTransaction().commit();

			System.out.println("Done!");
		} finally {
			session.close();
			factory.close();
		}
	}
}
