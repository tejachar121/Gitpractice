package com.example.demo.serv;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.example.demo.entity.Cart;
import com.example.demo.repo.CartRepo;
import com.example.demo.vo.Customer;
import com.example.demo.vo.Product;

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
    public Cart addToCart(int cid, int pid, int qty) {

        // ✅ Call Customer Service
        Customer customer = restTemplate.getForObject(
        		"http://CUSTOMER-SERVICE/customer/" + cid, Customer.class);

        // ✅ Call Product Service
        Product product = restTemplate.getForObject(
        		"http://PRODUCT-SERVICE/product/" + pid, Product.class);

        double total = product.getCost() * qty;

        Cart cart = new Cart();
        cart.setCid(cid);
        cart.setPid(pid);
        cart.setQuantity(qty);
        cart.setTotalPrice(total);

        // ✅ Reward Logic
        int reward = (int) (total / 10);
        customer.setRewardPoints(customer.getRewardPoints() + reward);

        // ✅ Update Customer back
        restTemplate.put("http://CUSTOMER-SERVICE/customer/" + "update", customer);

        return cartRepo.save(cart);
    }
}
