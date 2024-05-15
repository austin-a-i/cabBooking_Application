package com.application.cabbookingdemo.controllers;

import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.application.cabbookingdemo.dtos.requests.DriverRequestDTO;
import com.application.cabbookingdemo.dtos.requests.RideRequestDTO;
import com.application.cabbookingdemo.entity.Driver;
import com.application.cabbookingdemo.services.DriverService;

@RestController
@RequestMapping("/driver")
public class DriverController {
	
	public Logger log = LoggerFactory.getLogger(DriverController.class);
			
	@Autowired
	private DriverService driverService;
	
	@GetMapping("/all")
	public List<Driver> retrieveAllDrivers() {
		return driverService.getAllDrivers();
	}

	@PostMapping("/add")
	public String addDriver(@RequestBody DriverRequestDTO driverRequest) {
        String addDriver = driverService.createDriver(driverRequest);
        return addDriver;
	}
	
	@GetMapping("/findCab")
	public List<Driver> findRide(@RequestParam String name, @RequestParam String source,
														@RequestParam String destination) {
		RideRequestDTO rideRequest = new RideRequestDTO(name, source, destination);
		List<Driver> rideOptions = driverService.findRideOptions(rideRequest);
		log.info("Ride Options", rideOptions.toString());
		return rideOptions;
	}
	
	@GetMapping("/chooseCab")
	public Optional<Driver> chooseRide(@RequestParam String name, @RequestParam String source,
														@RequestParam String destination) {
		RideRequestDTO rideRequest = new RideRequestDTO(name, source, destination);
		Optional<Driver> bestRide = driverService.chooseQuickestRide(rideRequest);
		return bestRide;
	}
	
	
}
