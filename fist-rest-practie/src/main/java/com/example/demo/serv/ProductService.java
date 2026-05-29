package com.example.demo.serv;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.bean.Product;
import com.example.demo.repo.ProductRepo;

@Service
public class ProductService implements IProductService {
	
	
	@Autowired
	ProductRepo repo;
	@Override
	public Product addProduct(Product pro) {
		// TODO Auto-generated method stub
		return repo.save(pro);
	}

	@Override
	public List<Product> getAllProduct() {
		// TODO Auto-generated method stub
		return repo.findAll();
	}

	@Override
	public Product getProductById(int pid) {
		// TODO Auto-generated method stub
		return repo.findById(pid).orElse(null);
	}

	@Override
	public Product updateProduct(Product pro) {
		// TODO Auto-generated method stub
		return repo.save(pro);
	}

	@Override
	public void deleteProduct(int pid) {
		
		repo.deleteById(pid);
		// TODO Auto-generated method stub
		
	}

}
