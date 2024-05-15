package com.application.cabbookingdemo.services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.application.cabbookingdemo.dtos.requests.DriverRequestDTO;
import com.application.cabbookingdemo.dtos.requests.RideRequestDTO;
import com.application.cabbookingdemo.entity.Driver;

@Service
public interface DriverService {

	String createDriver(DriverRequestDTO driverRequest);

	List<Driver> getAllDrivers();

	List<Driver> findRideOptions(RideRequestDTO rideRequest);

	Optional<Driver> chooseQuickestRide(RideRequestDTO rideRequest);

}
