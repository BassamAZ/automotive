package com.automotive.simulator.client;


import java.util.List;
import java.util.Optional;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.automotive.simulator.model.Vehicle;

@FeignClient(name="automotive" ,url="http://localhost:8050")
public interface VehicleClient {

    @GetMapping("/automotive/vehicle")
    List<Vehicle> findAll();

    @PostMapping("/automotive/vehicle/{id}")
    Optional<Vehicle> pulse(@PathVariable("id") String id);
}
