package com.example.demo.serv;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entity.Product;
import com.example.demo.repo.ProductRepo;

@Service
public class ProductService implements IProductService {
	

	    @Autowired
	    ProductRepo repo;

	    public Product save(Product p) {
	        return repo.save(p);
	    }

	    public Product get(int pid) {
	        return repo.findById(pid).orElse(null);
	    }

		@Override
		public void deleteProductById(int pid) {
			repo.deleteById(pid);
			
		}
	    

}
