/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mars.springboot.cruddemo.dao;

import com.mars.springboot.cruddemo.entity.Employee;
import java.util.List;
import javax.persistence.EntityManager;
import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

/**
 *
 * @author mars
 */
@Repository
public class EmployeeDAOHibernateEmpl implements EmployeeDAO{

    // define field for entity manager
    private EntityManager entityManager;
    
    
    // setup constructor injection
    @Autowired
    public EmployeeDAOHibernateEmpl(EntityManager entityManager){
        this.entityManager = entityManager;
    }
    
    @Override
    public List<Employee> findAll() {
        
        // get the current hibernate session 
        Session currentSession = entityManager.unwrap(Session.class);
        // create a query
        Query<Employee> myQuery  = currentSession.createQuery("from Employee", Employee.class);
         
        
        // execute query and get result list
        List<Employee> employees = myQuery.getResultList();
        
        
        // return the results
        return employees;
    }

    @Override
    public Employee findById(int id) {
        // get the current hibernate session 
        Session currentSession = entityManager.unwrap(Session.class);
        
        // get the employee
        Employee emplloyee = currentSession.get(Employee.class, id);
                
        // return the employee
        return emplloyee;
    }

    @Override
    public void save(Employee employee) {
        // get the current hibernate session 
        Session currentSession = entityManager.unwrap(Session.class);
        
        // save employee
        currentSession.saveOrUpdate(employee);
    }

    @Override
    public void deleteById(int id) {
        // get the current hibernate session 
        Session currentSession = entityManager.unwrap(Session.class);
        
        // delete object with primary key
        Query myQuery = currentSession.createQuery("delete from Employee where id=:employeeId");
        myQuery.setParameter("employeeId", id);
        myQuery.executeUpdate();
    }
    
}
