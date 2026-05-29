package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.bean.Location;
import com.example.demo.serv.ILocationService;

@RestController
@RequestMapping("/location")
public class LocationController {

    @Autowired
    ILocationService repo;

    @PostMapping("/add")
    public Location addLocation(@RequestBody Location loc) {
        return repo.addLocation(loc);
    }
}
