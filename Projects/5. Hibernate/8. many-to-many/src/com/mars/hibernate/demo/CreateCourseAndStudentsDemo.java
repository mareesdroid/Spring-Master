package com.mars.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.mars.hiibernate.entity.Course;
import com.mars.hiibernate.entity.Instructor;
import com.mars.hiibernate.entity.InstructorDetail;
import com.mars.hiibernate.entity.Review;
import com.mars.hiibernate.entity.Student;

public class CreateCourseAndStudentsDemo {

	public static void main(String[] args) {
		// Create Session Factory

		SessionFactory factory = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Instructor.class)
				.addAnnotatedClass(InstructorDetail.class).addAnnotatedClass(Course.class)
				.addAnnotatedClass(Review.class).addAnnotatedClass(Student.class).buildSessionFactory();
		// Create Session

		Session session = factory.getCurrentSession();
		try {
			// strat a transaction
			session.beginTransaction();

			// create a course
			System.out.println("Creating a Course...");
			Course tempCourse = new Course("Kamehamea - Beginner to master");
			session.save(tempCourse);
			System.out.println("Saved Course");
			System.out.println("Creating Students...");
			// add some students
			Student tempStudent1 = new Student("Marees", "A", "mareesdroid@gmail.com");
			Student tempStudent2 = new Student("Yuva", "A", "yuva@gmail.com");
			Student tempStudent3 = new Student("Ela", "A", "ela@gmail.com");

			tempCourse.addStudent(tempStudent1);
			tempCourse.addStudent(tempStudent2);
			tempCourse.addStudent(tempStudent3);

			System.out.println("Saving Students...");
			session.save(tempStudent1);
			session.save(tempStudent2);
			session.save(tempStudent3);

			System.out.println("Saved");
			session.getTransaction().commit();

			System.out.println("Done!");
		} finally {
			session.close();
			factory.close();
		}
	}
}
