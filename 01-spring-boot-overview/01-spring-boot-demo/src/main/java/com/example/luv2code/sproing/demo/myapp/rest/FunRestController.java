package com.example.luv2code.sproing.demo.myapp.rest;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class FunRestController {

    // expose "/" that return "Hello World"
    @GetMapping("hello")
    public String sayHello(){
        return "Hello World";
    }
}
