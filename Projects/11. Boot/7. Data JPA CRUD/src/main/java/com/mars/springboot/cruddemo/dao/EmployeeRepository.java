/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mars.springboot.cruddemo.dao;

import com.mars.springboot.cruddemo.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 *
 * @author mars
 */
public interface EmployeeRepository extends JpaRepository<Employee, Integer>{
    /// that's it ... no need to write dao, dao impl, data jpa handle all
}
