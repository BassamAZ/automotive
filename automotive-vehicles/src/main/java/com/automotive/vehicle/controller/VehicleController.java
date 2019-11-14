package com.automotive.vehicle.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.automotive.vehicle.model.Vehicle;
import com.automotive.vehicle.service.VehicleService;

import springfox.documentation.swagger2.annotations.EnableSwagger2;

@RestController
@EnableSwagger2
@RequestMapping("/automotive")
@CrossOrigin("*")
public class VehicleController {

	@Autowired
	VehicleService vehicleService;

	@GetMapping("/vehicle")
	public List<Vehicle> getAllVehicles() {

		return vehicleService.findAll();

	}

	@GetMapping("/vehicle/{id}")
	public Vehicle getVehicle(@PathVariable("id") String id) {
		return vehicleService.findById(id);

	}

	public Vehicle getDummyVehicle(String id) {
		return vehicleService.findDummyVehicle();
	}

	@PostMapping("/vehicle/{id}")
	public Vehicle pulse(@PathVariable("id") String id) {
		return vehicleService.pulse(id).orElse(null);

	}

	@PostMapping("/vehicle")
	public Vehicle registerVehicle(@RequestBody Vehicle vehicle){
		return vehicleService.createVehicle(vehicle);

	}
	
	public void setVehicleService(VehicleService vehicleService) {
		this.vehicleService = vehicleService;
	}

	public VehicleService getVehicleService() {
		return vehicleService;
	}
}
