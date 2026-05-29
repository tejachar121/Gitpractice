package com.example.demo.serv;

import java.util.List;

import com.example.demo.bean.Product;

public interface IProductService {
	public Product addProduct(Product Pro);
	public List<Product> getAllProduct();
	public Product getProductById(int pid);
	public Product updateProduct(Product pro);
	public void deleteProduct(int pid);
	

}
