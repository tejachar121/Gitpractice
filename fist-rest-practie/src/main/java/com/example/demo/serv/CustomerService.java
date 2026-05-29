package com.example.demo.serv;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.bean.Customer;
import com.example.demo.repo.CustomerRepo;

@Service
public class CustomerService implements ICustomerService {
	
	@Autowired
	CustomerRepo repo;
	

	@Override
	public Customer addCustomer(Customer cus) {
		// TODO Auto-generated method stub
		return repo.save(cus);
	}

	@Override
	public List<Customer> getAllCustomer() {
		// TODO Auto-generated method stub
		return repo.findAll();
	}

	@Override
	public Customer getCustomerById(int cId) {
		// TODO Auto-generated method stub
		return repo.findById(cId).orElse(null);
	}

	@Override
	public Customer updateCustomer(Customer cus) {
		// TODO Auto-generated method stub
		return repo.save(cus);
	}

	@Override
	public void deleteCustomerById(int cid) {
		repo.deleteById(cid);
		// TODO Auto-generated method stub
		
	}

}
