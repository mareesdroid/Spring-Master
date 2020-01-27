/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mars.springboot.cruddemo.dao;

import com.mars.springboot.cruddemo.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

/**
 *
 * @author mars
 */

// to change custom api end points
@RepositoryRestResource(path="mebers")
public interface EmployeeRepository extends JpaRepository<Employee, Integer>{
    /// that's it ... no need to write dao, dao impl, data jpa handle all
}
