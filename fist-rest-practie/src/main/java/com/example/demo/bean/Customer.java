package com.example.demo.bean;

import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "Customer")
public class Customer {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int cid;
	private String cName;
	private int rewardPoints;
	@ManyToOne
	@JoinColumn(name = "location_id")
	private Location location;

	@OneToMany(mappedBy = "customer", cascade = CascadeType.ALL)
	private List<Cart> carts;

	public List<Cart> getCarts() {
		return carts;
	}

	public void setCarts(List<Cart> carts) {
		this.carts = carts;
	}

	public Customer() { // Constructor

	}

	public Customer(int cid, String cName, int rewardPoints, Location location, List<Cart> carts) {
		super();
		this.cid = cid;
		this.cName = cName;
		this.rewardPoints = rewardPoints;
		this.location = location;
		this.carts = carts;
	}

	public int getcId() {
		return cid;
	}

	public void setcId(int cId) {
		this.cid = cId;
	}

	public String getCName() {
		return cName;
	}

	public void setCName(String cName) {
		this.cName = cName;
	}

	public int getRewardPoints() {
		return rewardPoints;
	}

	public void setRewardPoints(int rewardPoints) {
		this.rewardPoints = rewardPoints;
	}

	@Override
	public String toString() {
		return "Customer [cid=" + cid + ", cName=" + cName + ", rewardPoints=" + rewardPoints + "]";
	}

	public Location getLocation() {
		return location;
	}

	public void setLocation(Location location) {
		this.location = location;
	}

}
