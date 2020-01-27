/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mars.springboot.cruddemo.service;

import com.mars.springboot.cruddemo.entity.Employee;
import java.util.List;

/**
 *
 * @author mars
 */
public interface EmployeeService {
    public List<Employee> findAll();
    
    public Employee findById(int id);
    
    public void save(Employee employee);
    
    public void deleteById(int theId);
}
