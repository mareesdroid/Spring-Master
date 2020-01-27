package com.mars.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.mars.hiibernate.entity.Course;
import com.mars.hiibernate.entity.Instructor;
import com.mars.hiibernate.entity.InstructorDetail;
import com.mars.hiibernate.entity.Review;
import com.mars.hiibernate.entity.Student;

public class DeleteMareesStudent {

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

			// get the pacman course from db
			int studentId = 1;
			Student myStudent = session.get(Student.class, studentId);
			// delete the course
			System.out.println("Deleteing Student : \n" + myStudent);
			session.delete(myStudent);
			// commit the transaction

			session.getTransaction().commit();

			System.out.println("Done!");
		} finally {
			session.close();
			factory.close();
		}
	}
}
