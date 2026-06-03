package com.example.demo.configuation;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.example.demo.entity.Customer;
import com.example.demo.repo.CustomerRepo;

@Service
public class UserInfoUserDetailsService implements UserDetailsService {  // UserDetailsServiceImp class

    @Autowired
    private CustomerRepo repository;

    @Override
    public UserDetails loadUserByUsername(String cname) throws UsernameNotFoundException {
        Optional<Customer> userInfo = repository.findByCname(cname);
        
        return userInfo.map(UserInfoUserDetails::new) 
                .orElseThrow(() -> new UsernameNotFoundException("user not found " + cname));

    }
}

