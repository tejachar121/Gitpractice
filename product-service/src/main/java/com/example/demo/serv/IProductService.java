package com.example.demo.serv;

import com.example.demo.entity.Product;

public interface IProductService {
	
	 public Product save(Product p);

	    public Product get(int pid);
	    public void deleteProductById(int pid);

}
