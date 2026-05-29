package com.example.demo.serv;

import java.util.List;

import com.example.demo.bean.Customer;

public interface ICustomerService {
	public Customer addCustomer(Customer cus);
	public List<Customer> getAllCustomer();
	public Customer getCustomerById(int cid);
	public Customer updateCustomer(Customer cus);
	public void deleteCustomerById(int cid);

}
