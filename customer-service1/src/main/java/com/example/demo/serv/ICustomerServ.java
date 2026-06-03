package com.example.demo.serv;

import com.example.demo.entity.Customer;

public interface ICustomerServ {
	
	 public Customer save(Customer c);

	    public Customer getCustomer(int cid);
	    
	    public void deleteCustomer(int cid);

}
