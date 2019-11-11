package com.automotive.simulator.scheduler;

import java.util.List;
import java.util.Random;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import com.automotive.simulator.client.VehicleClient;
import com.automotive.simulator.model.Vehicle;

@Component
public class VehicleScheduler {

    private static final Logger logger = LoggerFactory.getLogger(VehicleScheduler.class);

    @Autowired
    private VehicleClient vehicleClient;

    private Random rand = new Random();

    @Scheduled(fixedRate = 55000)
    public void pingVehicle() {

        logger.info("ping Vehicle");

        List<Vehicle> vehicleList = vehicleClient.findAll();

        int vehicleCnt = rand.nextInt(vehicleList.size() - 1) + 1;

        for (int i = 0; i < vehicleCnt; i++) {
            int randomIndex = rand.nextInt(vehicleList.size());
            Vehicle randomVehicle = vehicleList.get(randomIndex);
            vehicleClient.pulse(randomVehicle.getId());
        }

    }
}
