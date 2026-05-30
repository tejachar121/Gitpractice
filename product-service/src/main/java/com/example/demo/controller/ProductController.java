package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entity.Product;
import com.example.demo.serv.IProductService;

@RestController
@RequestMapping("/product")
public class ProductController {

    @Autowired
    IProductService service;

    @PostMapping("/add")
    public Product add(@RequestBody Product p) {
        return service.save(p);
    }

    @GetMapping("/{pid}")
    public Product getProduct(@PathVariable int pid) {
        return service.get(pid);
    }
}
