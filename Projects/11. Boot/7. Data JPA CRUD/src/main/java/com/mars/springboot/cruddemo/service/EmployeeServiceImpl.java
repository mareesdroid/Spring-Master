/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mars.springboot.cruddemo.service;


import com.mars.springboot.cruddemo.dao.EmployeeRepository;
import com.mars.springboot.cruddemo.entity.Employee;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


/**
 *
 * @author mars
 */

@Service
public class EmployeeServiceImpl implements EmployeeService{
private EmployeeRepository employeeRepository;

@Autowired
public EmployeeServiceImpl(EmployeeRepository employeeRepository){
this.employeeRepository = employeeRepository;
}
    @Override
    public List<Employee> findAll() {
        return employeeRepository.findAll();
    }

    @Override
    public Employee findById(int id) {
        Optional<Employee> result = employeeRepository.findById(id);
        Employee employee = null;
        if(result.isPresent()){
            employee = result.get();
        } else{
            // we didn't find the employees
            throw new RuntimeException("Did not find employee id - " + id);
        }
        return employee;
    }

    @Override
    public void save(Employee employee) {
        employeeRepository.save(employee);
    
    }
    @Override
    public void deleteById(int theId) {
        employeeRepository.deleteById(theId);
    }
    
}
