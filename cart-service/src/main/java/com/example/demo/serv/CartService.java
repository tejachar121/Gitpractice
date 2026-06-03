package com.example.demo.serv;

import java.util.function.Supplier;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.example.demo.entity.Cart;
import com.example.demo.exceptionhandling.CartNotFoundException;
import com.example.demo.exceptionhandling.CustomerNotFoundException;
import com.example.demo.exceptionhandling.ProductNotFoundException;
import com.example.demo.repo.CartRepo;
import com.example.demo.vo.Customer;
import com.example.demo.vo.Product;

import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;

@Service
public class CartService implements ICartService {

    @Autowired
    CartRepo cartRepo;

    @Autowired
    private RestTemplate restTemplate;

	/*
	 * private final String CUSTOMER_URL = "http://localhost:8082/customer/";
	 * private final String PRODUCT_URL = "http://localhost:8083/product/";
	 */
    @CircuitBreaker(name = "cartService", fallbackMethod = "fallbackAddToCart")
    public Cart addToCart(int cid, int pid, int qty) {

       
        Customer customer = restTemplate.getForObject(
        		"http://CUSTOMER-SERVICE/customer/" + cid, Customer.class);

if (customer == null) {
    throw new CustomerNotFoundException("Customer not found with id: " + cid);
}

        
        Product product = restTemplate.getForObject(
        		"http://PRODUCT-SERVICE/product/" + pid, Product.class);

if (product == null) {
    throw new ProductNotFoundException("Product not found with id: " + pid);
}

        double total = product.getCost() * qty;

        Cart cart = cartRepo.findByCidAndPid(cid, pid).orElse(new Cart());
        cart.setCid(cid);
        cart.setPid(pid);
        cart.setQuantity(qty);
        cart.setTotalPrice(total);

       
        int reward = (int) (total / 10);
        customer.setRewardPoints(customer.getRewardPoints() + reward);

        
        restTemplate.put("http://CUSTOMER-SERVICE/customer/" + "update", customer);

        return cartRepo.save(cart);
    }
    
    public Cart fallbackAddToCart(int cid, int pid, int qty, Exception ex) {

        System.out.println("Fallback triggered due to: " + ex.getMessage());

        Cart cart = cartRepo.findByCidAndPid(cid, pid).orElse(new Cart());
        cart.setCid(cid);
        cart.setPid(pid);
        cart.setQuantity(qty);
        cart.setTotalPrice(0);

        return cart; 
    }
    public Cart removeFromCart(int cid,int pid,int qty) {
    	
    	Customer customer = restTemplate.getForObject(
        		"http://CUSTOMER-SERVICE/customer/" + cid, Customer.class);

        
        Product product = restTemplate.getForObject(
        		"http://PRODUCT-SERVICE/product/" + pid, Product.class);
        
        double total = product.getCost() * qty;

        Cart cart = cartRepo.findByCidAndPid(cid, pid).orElseThrow(()-> new CartNotFoundException("No cart with id="+cid));
        cart.setCid(cid);
        cart.setPid(pid);
        cart.setQuantity(qty);
        cart.setTotalPrice(total);
        
        restTemplate.put("http://CUSTOMER-SERVICE/customer/" + "update", customer);

        return cartRepo.save(cart);
    	
    }
}
