package com.example.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.example.demo.entity.Customer;
import com.example.demo.repo.CustomerRepo;

@Service
public class UserDetailsServiceImp  implements  UserDetailsService {
	
		@Autowired
		CustomerRepo repo;

	@Override
	public UserDetails loadUserByUsername(String cname) throws UsernameNotFoundException {
		
		
				Customer user =			repo.findByCname(cname);
				
				if(user == null)
				{
					
					throw  new UsernameNotFoundException(cname);
					
				}		
		
		return   new UserDetailsImp(user);
	}

}
