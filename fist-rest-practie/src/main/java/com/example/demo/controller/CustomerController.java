package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.bean.Customer;
import com.example.demo.serv.ICustomerService;

@RestController
@RequestMapping("/Customer")
public class CustomerController {

	@Autowired
	ICustomerService service;
	

	@PostMapping(value="/add")
	public Customer addCustomer(@RequestBody Customer c) {
		return service.addCustomer(c);
	}

	@GetMapping("/all")
	public List<Customer> getAllCustomer() {
		return service.getAllCustomer();
	}
	@GetMapping("/getbycid/{cid}")
	public Customer getCustomerById(@PathVariable int cid) {

		return service.getCustomerById(cid);

	}
	@DeleteMapping("/deletebycid/{cid}")
	public String deleteCustomerById(@PathVariable int cid) {

		String msg = "";
		service.deleteCustomerById(cid);

		Customer cus = service.getCustomerById(cid);

		if (cus == null) {

			msg = "Record Deleted Successfully ";
		}

		return msg;
	}
	

}
