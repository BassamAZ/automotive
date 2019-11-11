package com.automotive.vehicle.repo;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.automotive.vehicle.model.Vehicle;

public interface VehicleRepository extends MongoRepository<Vehicle, String> {


    public Vehicle findByRegistrationNumber(String registrationNumber);
    public List<Vehicle> findByName(String name);
    public Vehicle findByPlateNumber(String plateNumber);
}
