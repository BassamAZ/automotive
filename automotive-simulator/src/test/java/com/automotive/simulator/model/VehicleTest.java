package com.automotive.simulator.model;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class VehicleTest {

    @Test
    void testVehicle() {

        Vehicle vehicle= new Vehicle();
        vehicle.setName("TestName");
        vehicle.setStatus(Status.CONNECTED.getStatusCode());
        vehicle.setModel("TestModel");
        vehicle.setId("TestId");
        vehicle.setPlateNumber("TestPlateNum");

        assertEquals(vehicle.getName(),"TestName");
        assertEquals(vehicle.getStatus(),Status.CONNECTED.getStatusCode());
        assertEquals(vehicle.getModel(),"TestModel");
        assertEquals(vehicle.getId(),"TestId");
        assertEquals(vehicle.getPlateNumber(),"TestPlateNum");

    }


}