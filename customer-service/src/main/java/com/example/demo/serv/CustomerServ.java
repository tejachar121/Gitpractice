package com.example.demo.serv;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entity.Customer;
import com.example.demo.repo.CustomerRepo;

@Service
public class CustomerServ implements ICustomerServ {

    @Autowired
    private CustomerRepo repo;

    public Customer save(Customer c) {
        return repo.save(c);
    }

    public Customer getCustomer(int cid) {
        return repo.findById(cid).orElse(null);
    }
}
