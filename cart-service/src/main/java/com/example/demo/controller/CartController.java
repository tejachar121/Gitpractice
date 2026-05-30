package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entity.Cart;
import com.example.demo.serv.ICartService;

@RestController
@RequestMapping("/cart")
public class CartController {

    @Autowired
    ICartService service;

    @PostMapping("/add")
    public Cart addToCart(@RequestParam int cid,
                          @RequestParam int pid,
                          @RequestParam int qty) {
        return service.addToCart(cid, pid, qty);
    }
}
