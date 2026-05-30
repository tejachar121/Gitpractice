package com.example.demo.serv;

import com.example.demo.entity.Cart;

public interface ICartService {

    public Cart addToCart(int cid, int pid, int qty);
}
