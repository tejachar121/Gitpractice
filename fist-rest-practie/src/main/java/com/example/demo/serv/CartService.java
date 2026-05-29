package com.example.demo.serv;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.bean.Cart;
import com.example.demo.bean.Customer;
import com.example.demo.bean.Product;
import com.example.demo.repo.CartRepo;
import com.example.demo.repo.CustomerRepo;
import com.example.demo.repo.ProductRepo;

@Service
public class CartService implements ICartService {
	@Autowired
	CartRepo cartro;
	@Autowired
	CustomerRepo customerro;
	@Autowired
	ProductRepo productro;

	@Override
	public Cart addToCart(int cid, int pid, int qty) {

		Customer customer = customerro.findById(cid).orElseThrow();
		Product product = productro.findById(pid).orElseThrow();

		double total = product.getCost() * qty;

		Cart cart = new Cart();
		cart.setCustomer(customer);
		cart.setProduct(product);
		cart.setQuantity(qty);

		cart.setTotalPrice(total);

		
		int points = (int) (total / 10);
		customer.setRewardPoints(customer.getRewardPoints() + points);

		customerro.save(customer);

		return cartro.save(cart);

	}

	@Override
	public List<Cart> getAllCartItems() {
		return cartro.findAll();
	}

}
