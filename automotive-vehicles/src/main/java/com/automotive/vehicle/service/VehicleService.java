package com.automotive.vehicle.service;

import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.automotive.vehicle.model.Status;
import com.automotive.vehicle.model.Vehicle;
import com.automotive.vehicle.repo.VehicleRepository;

@Service
public class VehicleService {

    @Autowired
    private VehicleRepository vehicleRepository;

    public List <Vehicle> findAll(){
        return vehicleRepository.findAll();
    }


    public Vehicle findById( String  id){

        if (StringUtils.isEmpty(id)){
            throw new IllegalArgumentException("There is a missing: id");
        }

        return vehicleRepository.findById(id).orElse(null);
    }

    public Vehicle findByRegistrationNumber(String registrationNumber){

        if (StringUtils.isEmpty(registrationNumber)){
            throw new IllegalArgumentException("There is a missing: registrationNumber");
        }

        return vehicleRepository.findByRegistrationNumber(registrationNumber);
    }

    public Vehicle findByPlateNumber(String plateNumber){

        if (StringUtils.isEmpty(plateNumber)){
            throw new IllegalArgumentException("There is a missing: plateNumber");
        }

        return vehicleRepository.findByPlateNumber(plateNumber);
    }

    public List<Vehicle> findByName(String name){

        if (StringUtils.isEmpty(name)){
            throw new IllegalArgumentException("There is a missing: name");
        }

        return vehicleRepository.findByName(name);
    }


    public Optional<Vehicle> pulse(String id){

        if (StringUtils.isEmpty(id)){
            throw new IllegalArgumentException("There is a missing: vehicleId");
        }

        return Optional.ofNullable(vehicleRepository.findById(id).map(vehicle -> {
            vehicle.setStatus(Status.CONNECTED.getStatusCode());
            vehicle.setLastUpdatedDate(LocalDateTime.now());
            vehicleRepository.save(vehicle);
            return vehicle;
        }).orElse(null));

    }


    public Vehicle findDummyVehicle(){

       Vehicle vehicle= new Vehicle();
       vehicle.setName("Dummy Name");
       vehicle.setModel("Dummy Model");

        return vehicle;
    }

    public Vehicle createVehicle( Vehicle  vehicle){

        if (vehicle==null){
        	
            throw new IllegalArgumentException("vehicle is mandatory input");
        }
        vehicle.setLastUpdatedDate(LocalDateTime.now());

        return vehicleRepository.save(vehicle);
    }
}
