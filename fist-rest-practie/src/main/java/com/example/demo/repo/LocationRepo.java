package com.example.demo.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.bean.Location;

@Repository
public interface LocationRepo extends JpaRepository<Location, Integer> {}
