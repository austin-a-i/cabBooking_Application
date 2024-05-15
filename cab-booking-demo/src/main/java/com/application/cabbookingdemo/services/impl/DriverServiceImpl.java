package com.application.cabbookingdemo.services.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.application.cabbookingdemo.converters.DriverConverter;
import com.application.cabbookingdemo.dtos.requests.DriverRequestDTO;
import com.application.cabbookingdemo.dtos.requests.RideRequestDTO;
import com.application.cabbookingdemo.entity.Driver;
import com.application.cabbookingdemo.entity.Location;
import com.application.cabbookingdemo.exceptions.NoCabFoundException;
import com.application.cabbookingdemo.exceptions.NameNotFoundException;
import com.application.cabbookingdemo.repository.DriverRepository;
import com.application.cabbookingdemo.repository.UserRepository;
import com.application.cabbookingdemo.services.DriverService;
import com.application.cabbookingdemo.utils.Utils;

import jakarta.transaction.Transactional;

@Component
public class DriverServiceImpl implements DriverService {
	
	public Logger log = LoggerFactory.getLogger(DriverServiceImpl.class);
	
	@Autowired
	private DriverRepository driverRepository;
	
	@Autowired
	private UserRepository userRepository;
	
	@Override
	public List<Driver> getAllDrivers() {
		return driverRepository.findAll();
	}

	@Override
	public String createDriver(DriverRequestDTO driverRequest) {
		Driver driver = DriverConverter.convertDtotoEntity(driverRequest);
		driverRepository.save(driver);
		return driver.getDriverName() + " has been added successfully ";
	}

	@Override
	public List<Driver> findRideOptions(RideRequestDTO rideRequest) {
		if( userRepository.findUserByUsername(rideRequest.getName()).isPresent() ) {
			log.info("User is present to book ride");
			List<Driver> allDrivers = getAllDrivers();
			List<Driver> availableDrivers = returnAvailableDrivers(allDrivers, rideRequest);
			if(availableDrivers.isEmpty()) {
				throw new NoCabFoundException("No cab found within 5 km vicinity");
			}
			return availableDrivers;
		}
		throw new NameNotFoundException("User Not Found");
	}
	
	@Override
	@Transactional
	public Optional<Driver> chooseQuickestRide(RideRequestDTO rideRequest) {
		if( userRepository.findUserByUsername(rideRequest.getName()).isPresent() ) {
			List<Driver> availableDrivers = findRideOptions(rideRequest);
			if(availableDrivers.isEmpty()) {
				throw new NoCabFoundException("No cab found within 5 km vicinity");
			}
			Optional<Driver> returnQuickestOption = returnQuickestOption(availableDrivers, rideRequest);
			return returnQuickestOption;
		}
		else {
			throw new NameNotFoundException("User Not Found");
		}
	}
	
	private Optional<Driver> returnQuickestOption(List<Driver> availableDrivers, RideRequestDTO rideRequest) {
		Location sourceLocation = Utils.parseLocation(rideRequest.getSource());
		double minimumDistance = 5;
		Driver bestRide = availableDrivers.get(0);
		for(Driver driver: availableDrivers) {
			if(driver.isAvailable()) {
				Location driverLocation = driver.getLocation();
				double distance = Utils.calculateDistance(sourceLocation, driverLocation);
				if( distance < minimumDistance ) {
					minimumDistance = distance;
					bestRide = driver;
				}
			}
		}
		bestRide.setAvailable(false);
		driverRepository.save(bestRide);
		return Optional.of(bestRide);
	}

	public List<Driver> returnAvailableDrivers(List<Driver> allDrivers ,RideRequestDTO rideRequest) {
		Location sourceLocation = Utils.parseLocation(rideRequest.getSource());
		log.info("Parsed source location {}", sourceLocation.toString());
		//Location destLocation = Utils.parseLocation(rideRequest.getDestination());
		List<Driver> availableDrivers = new ArrayList<Driver>();
		for(Driver driver: allDrivers) {
			Location driverLocation = driver.getLocation();
			if(Utils.calculateDistance(sourceLocation, driverLocation) <= 5) {
				log.info("Adding driver to list {}", driver);
				availableDrivers.add(driver);
			}
			else {
				log.info("Not Adding driver to list {}", driver);
			}
		}
		return availableDrivers;
	}

}
