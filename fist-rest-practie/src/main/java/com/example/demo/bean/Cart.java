package com.example.demo.bean;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Entity
public class Cart {
	@Id
	private int cartId;
	private int quantity;
	@ManyToOne
	@JoinColumn(name = "cid")
	private Customer customer;

	
	@ManyToOne
	@JoinColumn(name = "pid")
	private Product product;
	private double totalPrice;

	public Cart() {

	}

	public Cart(int cartId, int quantity, Customer customer, double totalPrice) {
		super();
		this.cartId = cartId;
		this.quantity = quantity;
		this.customer = customer;
		this.totalPrice = totalPrice;
	}

	public int getCartId() {
		return cartId;
	}

	public void setCartId(int cartId) {
		this.cartId = cartId;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}


	public double getTotalPrice() {
		return totalPrice;
	}

	public void setTotalPrice(double totalPrice) {
		this.totalPrice = totalPrice;
	}
	
	public Customer getCustomer() {
		return customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

	public Product getProduct() {
		return product;
	}

	public void setProduct(Product product) {
		this.product = product;
	}


}
