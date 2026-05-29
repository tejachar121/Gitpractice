package com.example.demo.serv;

import java.util.List;

import com.example.demo.bean.Location;

public interface ILocationService {
	public Location addLocation(Location loc);
	public List<Location> getAllLocation();
	public Location getLocationById(int lid);
	public Location updateLocation(Location loc);
	public void deleteLocation(int lid);

}
