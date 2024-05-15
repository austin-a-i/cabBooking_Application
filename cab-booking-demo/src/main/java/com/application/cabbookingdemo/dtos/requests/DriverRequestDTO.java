package com.application.cabbookingdemo.dtos.requests;

import com.application.cabbookingdemo.entity.Location;
import com.application.cabbookingdemo.entity.Sex;
import com.application.cabbookingdemo.entity.Vehicle;

import lombok.Data;

@Data
public class DriverRequestDTO {
	
    private String driverName;
	private Sex sex;
    private Vehicle vehicle;
    private Location location;
    
}
