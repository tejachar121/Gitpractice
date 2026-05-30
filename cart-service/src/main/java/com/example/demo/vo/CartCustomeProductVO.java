package com.example.demo.vo;

import com.example.demo.entity.Cart;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CartCustomeProductVO {
	private Cart cart;
	private Customer customer;
	private Product product;

}
