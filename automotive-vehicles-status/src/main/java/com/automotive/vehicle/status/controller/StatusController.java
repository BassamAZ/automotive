package com.automotive.vehicle.status.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.automotive.vehicle.status.model.Vehicle;
import com.automotive.vehicle.status.service.StatusService;

import springfox.documentation.swagger2.annotations.EnableSwagger2;

@RestController
@EnableSwagger2
@RequestMapping("/automotive")
public class StatusController {

	@Autowired
	StatusService statusService;
	
	@GetMapping("/status")
	public List <Vehicle> getStatuses(){

		return statusService.findAllStatus();
	}

	@GetMapping("/status/{vehicleId}")
	public Vehicle getStatus(@PathVariable("vehicleId")String vehicleId){
		return statusService.findStatus(vehicleId);

	}


	public Vehicle getDummyStatus(String id){
		return statusService.findDummyVehicle();
	}


	public void setStatusService(StatusService statusService) {
		this.statusService = statusService;
	}

	public StatusService getStatusService() {
		return statusService;
	}
}

