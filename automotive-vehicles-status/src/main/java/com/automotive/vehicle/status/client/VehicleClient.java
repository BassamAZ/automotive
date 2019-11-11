package com.automotive.vehicle.status.client;


import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.automotive.vehicle.status.model.Vehicle;

@FeignClient(name="automovite-vehicles" ,url="http://localhost:8080")
public interface VehicleClient {

    @GetMapping("/automotive/vehicle")
    List<Vehicle> findAll();

    @GetMapping("/automotive/vehicle/{id}")
    Vehicle getVehicle(@PathVariable("id")String id);


}
