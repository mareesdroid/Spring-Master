/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mars.springboot.cruddemo.rest;


import com.mars.springboot.cruddemo.entity.Employee;
import com.mars.springboot.cruddemo.service.EmployeeService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author mars
 */
@RestController
@RequestMapping("/api")
public class EmployeeRestController {

    private EmployeeService employeeService;
    
    @Autowired
    public EmployeeRestController(EmployeeService employeeService){
        this.employeeService = employeeService;
    }
    // expose "/employees" and return list of employees
    @GetMapping("/employees")
    public List<Employee> findAll(){
        return employeeService.findAll();
    }
    // add mapping for PUT /employees - update existing employee
    
    @PutMapping("/employees")
    public Employee updateEmployee(@RequestBody Employee employee){
    employeeService.save(employee);
    return employee;
    }
    
     // add mapping for GET /employees/id - get existing employee by id
    @GetMapping("/employees/{employeeId}")
    public Employee getEmployee(@PathVariable int employeeId){
        Employee theEmployee = employeeService.findById(employeeId);
        
        if(theEmployee == null){
            throw new RuntimeException("Employee Id not found - " + employeeId);
        }
        
        return theEmployee;
    }
    
   // add mapping for POST /employees - add employee
    @PostMapping("/employees")
    public Employee addEmployee(@RequestBody Employee theEmployee){
        // also just in case they pass an id in JSON ... set id to 0
        // this is to force a save of new item ... instead of update
        
        theEmployee.setId(0);
        employeeService.save(theEmployee);
        return theEmployee;
    }
    // delete employee DELETE /employees - delete employee
    @DeleteMapping("/employees/{employeeId}")
    public String deleteEmployee(@PathVariable int employeeId){
        Employee tempEmployee = employeeService.findById(employeeId);
        
        // throw exception if null
        
        if(tempEmployee == null){
            throw new RuntimeException("Employee id not found - " + employeeId);
        }
        
        employeeService.deleteById(employeeId);
        return "deleted employee id - " + employeeId;
    }
}
