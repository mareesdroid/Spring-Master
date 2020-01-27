package com.mars.spring.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.mars.spring.entity.Customer;

import java.util.List;

@Repository
public class CustomerDaoImpl implements CustomerDAO {

	// need to inject the session factory
	@Autowired
	private SessionFactory sessionFactory;   //same name as the bean id check mvc-crud-servlet.xml
	
	
	@Override
	
	public List<Customer> getCustomers() {
		Session currentSession = sessionFactory.getCurrentSession();
		
		// create a query
		Query<Customer> theQuery = 
				currentSession.createQuery("from Customer order by firstName", Customer.class);
		
		// execute query and get result list
		List<Customer> customers = theQuery.getResultList();
				
		// return the results		
		return customers;
		
	}


	@Override
	public void saveCustomer(Customer theCustomer) {
		
		// get current hibernate session
		Session currentSession = sessionFactory.getCurrentSession(); 
		
		//save the customer
		//currentSession.save(theCustomer);
		
		/* 
		 * save adds a new customer we need to update customer if already existed else add customer if not existed
		 * 
		 * 			saveOrUpdate
		 * p.s.
		 * 		if (id) emty{
		 * 	insert new customer
		 * } else {
		 * 	update customer
		 * }
		 */
		
		System.out.println(theCustomer);
		currentSession.saveOrUpdate(theCustomer);
		
	}


	@Override
	public Customer getCustomer(int theId) {
		
		// get the current hibernate session
		
		Session currentSession = sessionFactory.getCurrentSession(); 
		
		// retrieve data from db using the primary key
		Customer theCustomer = currentSession.get(Customer.class,  theId);
		
		return theCustomer;
	}


	@Override
	public void deleteCustomer(int theId) {
				// create session
		
				Session currentSession = sessionFactory.getCurrentSession();
				
				// get customer
				Customer theCustomer = currentSession.get(Customer.class, theId);
				System.out.println("@Dao : " + theCustomer);
				//delete the customer
				currentSession.delete(theCustomer);
		
	}

	




	

	
}
