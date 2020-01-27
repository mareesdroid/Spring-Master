package com.mars.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.mars.hiibernate.entity.Course;
import com.mars.hiibernate.entity.Instructor;
import com.mars.hiibernate.entity.InstructorDetail;
import com.mars.hiibernate.entity.Review;
import com.mars.hiibernate.entity.Student;

public class AddCoursesForMarees {

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

			// get the student marees from the database
			int studentId = 1; // check sql db for id
			Student tempStudent = session.get(Student.class, studentId);
			System.out.println("Students selected : \n" + tempStudent);
			System.out.println("Student Courses are : \n" + tempStudent.getCourses());

			// create more courses

			Course newCourse1 = new Course("Super Saiyan 2 - Grade 3");
			Course newCourse2 = new Course("Ultra Instinct");

			// add student to the courses
			newCourse1.addStudent(tempStudent);
			newCourse2.addStudent(tempStudent);
			// save the courses
			System.out.println("Saving the course");
			session.save(newCourse1);
			session.save(newCourse2);
			// commit the transaction

			session.getTransaction().commit();

			System.out.println("Done!");
		} finally {
			session.close();
			factory.close();
		}
	}
}
