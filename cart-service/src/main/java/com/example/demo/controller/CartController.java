package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entity.Cart;
import com.example.demo.serv.ICartService;

@RestController
@RequestMapping("/cart")
public class CartController {

    @Autowired
    ICartService service;

    @GetMapping("/add/{cid}/{pid}/{qty}")
    public Cart addToCart(@PathVariable int cid,
                          @PathVariable int pid,
                          @PathVariable int qty) {
        return service.addToCart(cid, pid, qty);
    }
    @PutMapping("/update/{cid}/{pid}/{qty}")
    public Cart removeFromCart(@PathVariable int cid,
            @PathVariable int pid,
            @PathVariable int qty) {
    	return service.removeFromCart(cid, pid, qty);
    }
}
