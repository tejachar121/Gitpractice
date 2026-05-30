package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entity.Customer;
import com.example.demo.serv.ICustomerServ;

@RestController
@RequestMapping("/customer")
public class CustomerController {

    @Autowired
    ICustomerServ service;

    @PostMapping("/add")
    public Customer addCustomer(@RequestBody Customer c) {
        return service.save(c);
    }

    @GetMapping("/{cid}")
    public Customer getCustomer(@PathVariable int cid) {
        return service.getCustomer(cid);
    }

    @PutMapping("/update")
    public Customer update(@RequestBody Customer c) {
        return service.save(c);
    }
}

