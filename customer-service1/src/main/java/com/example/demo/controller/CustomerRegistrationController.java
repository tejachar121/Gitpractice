package com.example.demo.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.dto.AuthRequest;
import com.example.demo.entity.Customer;
import com.example.demo.serv.CustomerServ;
import com.example.demo.serv.JwtService;

@RestController
@RequestMapping("/customer")
public class CustomerRegistrationController {

	@Autowired
	CustomerServ service;

	@Autowired
	JwtService jwtService;

	@Autowired
	AuthenticationManager authenticationManager;

	Logger logger = LoggerFactory.getLogger(CustomerRegistrationController.class);

	@PostMapping("/registration/new")
	public String addNewUser(@RequestBody Customer userInfo) {
		return service.addUser(userInfo);
	}

	@PostMapping("/login/authenticate")
	public String authenticateAndGetToken(@RequestBody AuthRequest authRequest) {

		Authentication authentication = authenticationManager.authenticate(
				new UsernamePasswordAuthenticationToken(authRequest.getUsername(), authRequest.getPassword()));
		
								

		String token = null;

		if (authentication.isAuthenticated()) {

			// call generate token method from jwtService class

			token = jwtService.generateToken(authRequest.getUsername());

			logger.info("Token : " + token);

		} else {

			logger.info("invalid");

			throw new UsernameNotFoundException("UserName or Password in Invalid / Invalid Request");

		}

		return token; // if it returns token in response body means login successful..

	}

}

