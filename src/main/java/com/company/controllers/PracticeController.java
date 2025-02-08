package com.company.controllers;

import com.company.models.Product;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/products")
public class PracticeController {

    Map<String, Product> productMap = new HashMap<>();

    @GetMapping("/a1")
    public String hello(){
        return "Hello";
    }



    @GetMapping("/a2")
    public String hello2(){
        return "Hello2";
    }
    @GetMapping("/p2")
    public Product getProduct(){
        Product cream = new Product("Nivea", "Face", 1);
        return cream;
    }

    @PostMapping("/create")
    public void createProduct(Product product){
        System.out.println(product.name());
        productMap.put(product.name(),product);
    }

    @GetMapping("/call")
    public Product callProduct(String name){
        return productMap.get(name);
    }

    @GetMapping("/all")
    public Collection<Product> callAll(){
        return productMap.values();
    }



}
