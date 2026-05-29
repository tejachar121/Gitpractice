package com.example.demo.serv;

import java.util.List;

import com.example.demo.bean.Cart;

public interface ICartService {
	public Cart addToCart(int cid,int pid,int qty);
	public List<Cart> getAllCartItems();
	

}
