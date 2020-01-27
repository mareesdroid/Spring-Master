package com.mars.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.mars.hiibernate.entity.Course;
import com.mars.hiibernate.entity.Instructor;
import com.mars.hiibernate.entity.InstructorDetail;

public class CreateCourseDemo {

	public static void main(String[] args) {
		// Create Session Factory

		SessionFactory factory = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Instructor.class)
				.addAnnotatedClass(InstructorDetail.class).addAnnotatedClass(Course.class).buildSessionFactory();
		// Create Session

		Session session = factory.getCurrentSession();
		try {

			session.beginTransaction();

			// get the instructor from db

			int theId = 1;
			Instructor tempInstructor = session.get(Instructor.class, theId);

			System.out.println(tempInstructor);
			// create som courses

			Course tempCourse1 = new Course("Galick Gun");
			Course tempCourse2 = new Course("Super Saiyan");
			Course tempCourse3 = new Course("Super Saiyan 2");
			Course tempCourse4 = new Course("Final Flash");
			Course tempCourse5 = new Course("Super Saiyan 4");

			//  add the courses for tempInstructor
			tempInstructor.add(tempCourse1);
			tempInstructor.add(tempCourse2);
			tempInstructor.add(tempCourse3);
			tempInstructor.add(tempCourse4);
			tempInstructor.add(tempCourse5);

			// save the courses
			session.save(tempCourse1);
			session.save(tempCourse2);
			session.save(tempCourse3);
			session.save(tempCourse4);
			session.save(tempCourse5);

			session.getTransaction().commit();

			System.out.println("Done!");
		} finally {
			session.close();
			factory.close();
		}
	}
}
