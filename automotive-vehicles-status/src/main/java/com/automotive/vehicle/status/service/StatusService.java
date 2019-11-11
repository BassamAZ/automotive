package com.automotive.vehicle.status.service;

import java.util.List;

import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.automotive.vehicle.status.client.VehicleClient;
import com.automotive.vehicle.status.model.Status;
import com.automotive.vehicle.status.model.Vehicle;


@Service
public class StatusService {

    @Autowired
    private VehicleClient vehicleClient;

    public Vehicle findDummyVehicle(){

       Vehicle vehicle= new Vehicle();
       vehicle.setName("Dummy Name");
       vehicle.setModel("Dummy Model");
       vehicle.setStatus(Status.CONNECTED.getStatusCode());

        return vehicle;
    }


    public Vehicle findStatus(String vehicleId){

        if (StringUtils.isEmpty(vehicleId)){
            throw new IllegalArgumentException("There is a missing: vehicleId");
        }

        return vehicleClient.getVehicle(vehicleId);
    }

    public List<Vehicle> findAllStatus(){

        return vehicleClient.findAll();
    }




	
	
	

}
