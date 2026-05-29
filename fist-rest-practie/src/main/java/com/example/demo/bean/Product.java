package com.example.demo.bean;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Product {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int pid;
	private String pName;
	private double cost;
	
	public Product(){}
	
	public Product(int pid, String pName, double cost) {
		super();
		this.pid = pid;
		this.pName = pName;
		this.cost = cost;
	}

	public int getId() {
		return pid;
	}
	public void setId(int pid) {
		this.pid = pid;
	}
	public String getPName() {
		return pName;
	}
	public void setPName(String pName) {
		this.pName = pName;
	}
	public double getCost() {
		return cost;
	}
	public void setCost(double cost) {
		this.cost = cost;
	}
	

}
