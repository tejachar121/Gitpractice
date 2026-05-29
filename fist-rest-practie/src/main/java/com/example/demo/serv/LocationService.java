package com.example.demo.serv;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.bean.Location;
import com.example.demo.repo.LocationRepo;

@Service
public class LocationService implements ILocationService {
	@Autowired
	LocationRepo repo;
	@Override
	public Location addLocation(Location loc) {
		// TODO Auto-generated method stub
		return repo.save(loc);
	}

	@Override
	public List<Location> getAllLocation() {
		// TODO Auto-generated method stub
		return repo.findAll();
	}

	@Override
	public Location getLocationById(int lid) {
		// TODO Auto-generated method stub
		return repo.findById(lid).orElse(null);
	}

	@Override
	public Location updateLocation(Location loc) {
		// TODO Auto-generated method stub
		return repo.save(loc);
	}

	@Override
	public void deleteLocation(int lid) {
		repo.deleteById(lid);
		// TODO Auto-generated method stub
		
	}

}
