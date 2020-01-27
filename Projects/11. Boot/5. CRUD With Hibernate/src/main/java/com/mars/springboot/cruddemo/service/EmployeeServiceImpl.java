/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mars.springboot.cruddemo.service;

import com.mars.springboot.cruddemo.dao.EmployeeDAO;
import com.mars.springboot.cruddemo.entity.Employee;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author mars
 */

@Service
public class EmployeeServiceImpl implements EmployeeService{
private EmployeeDAO employeeDAO;

@Autowired
public EmployeeServiceImpl(EmployeeDAO employeeDao){
    employeeDAO = employeeDao;
}
    @Override
    @Transactional
    public List<Employee> findAll() {
        return employeeDAO.findAll();
    }

    @Override
    @Transactional
    public Employee findById(int id) {
        return employeeDAO.findById(id);
    }

    @Override
    @Transactional
    public void save(Employee employee) {
        employeeDAO.save(employee);
    
    }
    @Override
    @Transactional
    public void deleteById(int theId) {
        employeeDAO.deleteById(theId);
    }
    
}
