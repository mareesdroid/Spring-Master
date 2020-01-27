/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mars.springboot.cruddemo.dao;

import com.mars.springboot.cruddemo.entity.Employee;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.Query;
import org.springframework.stereotype.Repository;

/**
 *
 * @author mars
 */
@Repository
public class EmployeeDAOJpaImpl implements EmployeeDAO{
    
    private EntityManager entityManager;

    public EmployeeDAOJpaImpl(EntityManager entityManager){
        this.entityManager = entityManager;
    }
    
    @Override
    public List<Employee> findAll() {
        // create a new query
        Query theQuery = entityManager.createQuery("from Employee", Employee.class);
        // execute query and get result list
        List<Employee> employees = theQuery.getResultList();
        //return the results
        return employees;
    }

    @Override
    public Employee findById(int id) {
        // get Employee
        Employee theEmployee = entityManager.find(Employee.class, id);
        
        // return employee
        return theEmployee;
    }

    @Override
    public void save(Employee employee) {
        // save or udate the employee
        Employee dbEmployee = entityManager.merge(employee);
        // update with id from db ... so we can get generated id for save/insert
        employee.setId(dbEmployee.getId());
    }

    @Override
    public void deleteById(int id) {
        // delete onject with primary key
        Query theQuery = entityManager.createQuery("delete from Employee where id=:employeeId");
        theQuery.setParameter("employeeId", id); 
        theQuery.executeUpdate();
    }
    
}
