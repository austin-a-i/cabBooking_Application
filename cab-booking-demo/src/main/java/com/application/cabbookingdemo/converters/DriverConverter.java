package com.application.cabbookingdemo.converters;

import com.application.cabbookingdemo.dtos.requests.DriverRequestDTO;
import com.application.cabbookingdemo.entity.Driver;
import com.application.cabbookingdemo.exceptions.NameNotFoundException;

public class DriverConverter {

	public static Driver convertDtotoEntity(DriverRequestDTO driverRequest) {
		if(driverRequest.getDriverName()!= null) {
			Driver driverResponse = Driver.builder()
											.driverName(driverRequest.getDriverName())
											.sex(driverRequest.getSex())
											.vehicle(driverRequest.getVehicle())
											.location(driverRequest.getLocation())
											.isAvailable(true)
					 						.build();
			return driverResponse;
		}
		throw new NameNotFoundException("Driver Username is null/not found");
	}

}
