package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.bean.Product;
import com.example.demo.serv.IProductService;

@RestController
@RequestMapping("/product")
public class ProductController {

    @Autowired
    IProductService repo;

    @PostMapping("/add")
    public Product addProduct(@RequestBody Product p) {
        return repo.addProduct(p);
    }

    @GetMapping("/all")
    public List<Product> getAll() {
        return repo.getAllProduct();
    }
}
