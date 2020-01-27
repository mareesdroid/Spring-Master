/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mars.spring.thymeleafdemo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

/**
 *
 * @author mars
 */
@Controller
public class DemoController {
    // create a mapping for "/hello"
    @GetMapping("/hello")
    public String sayHello(Model myModel){
        
        myModel.addAttribute("myDate", new java.util.Date());
                ///// it will automatically go and look for helloworld.html in src/main/resources/templates
        return "helloworld";
        
    }
}
