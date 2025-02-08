package com.company.controllers;

import com.company.models.Product;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/products")
public class PracticeController {

    @GetMapping("/a1")
    public String hello(){
        return "Hello";
    }

    @GetMapping("/a2")
    public String hello2(){
        return "Hello2";
    }
    @GetMapping("/p1")
    public Product getProduct(){
        Product cream = new Product("Nivea", "Face", 1);
        return cream;
    }
}
