package com.automotive.vehicle.controller;

import static org.mockito.Mockito.mock;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.automotive.vehicle.model.Status;
import com.automotive.vehicle.model.Vehicle;
import com.automotive.vehicle.service.VehicleService;

@RunWith(SpringRunner.class)
@SpringBootTest
public class VehicleControllerTest {

    @Test
    public void getAllVehicles() {

        VehicleService mockVehicleService=mock(VehicleService.class);

        List<Vehicle> mockVehicleList= new ArrayList<Vehicle>(){{add(new Vehicle("YS2R4X20005399401","FORD","F150","ABC123","ABC123", Status.CONNECTED.getStatusCode())); }};

        Mockito.when(mockVehicleService.findAll()).thenReturn(mockVehicleList);

        VehicleController vehicleController=new VehicleController();
        vehicleController.setVehicleService(mockVehicleService);

        List<Vehicle> vehicleList=vehicleController.getAllVehicles();

        Assert.assertEquals(1 , vehicleList.size());

    }

    @Test
    public void getVehicle() {

        VehicleService mockVehicleService=mock(VehicleService.class);

        Vehicle mockVehicle= new Vehicle("YS2R4X20005399401","FORD","F150","ABC123","ABC123", Status.CONNECTED.getStatusCode());

        Mockito.when(mockVehicleService.findById("YS2R4X20005399401")).thenReturn(mockVehicle);

        VehicleController vehicleController=new VehicleController();
        vehicleController.setVehicleService(mockVehicleService);

        Vehicle vehicle=vehicleController.getVehicle("YS2R4X20005399401");

        Assert.assertEquals("F150", vehicle.getModel());
    }

    @Test
    public void getDummyVehicle() {

        VehicleService mockVehicleService=mock(VehicleService.class);

        Vehicle mockVehicle= new Vehicle("YS2R4X20005399401","FORD","F150","ABC123","ABC123", Status.CONNECTED.getStatusCode());

        Mockito.when(mockVehicleService.findDummyVehicle()).thenReturn(mockVehicle);

        VehicleController vehicleController=new VehicleController();
        vehicleController.setVehicleService(mockVehicleService);

        Vehicle vehicle=vehicleController.getDummyVehicle("YS2R4X20005399401");

        Assert.assertEquals("F150", vehicle.getModel());
    }

    @Test
    public void pulse() {

        VehicleService mockVehicleService=mock(VehicleService.class);

        Optional<Vehicle> mockVehicle= Optional.of(new Vehicle("YS2R4X20005399401","FORD","F150","ABC123","ABC123", Status.CONNECTED.getStatusCode()));

        Mockito.when(mockVehicleService.pulse("YS2R4X20005399401")).thenReturn(mockVehicle);

        VehicleController vehicleController=new VehicleController();
        vehicleController.setVehicleService(mockVehicleService);

        Vehicle vehicle=vehicleController.pulse("YS2R4X20005399401");

        Assert.assertEquals("F150", vehicle.getModel());
    }
}