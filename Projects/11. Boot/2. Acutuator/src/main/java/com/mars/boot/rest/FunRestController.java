/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mars.boot.rest;

import java.time.LocalDateTime;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;


/**
 *
 * @author mars
 */
@RestController
public class FunRestController {
    // expose "/" that return "Hello World"
    
    @GetMapping("/")
    public String sayHello(){
        return "Hello World! Time on server is " + LocalDateTime.now();
    }
    
    @GetMapping("/workout")
    public String getWorkout(){
        return "do a hard 5k!";
    }
}
