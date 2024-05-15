package com.application.cabbookingdemo.entity;

import jakarta.persistence.Embeddable;

@Embeddable
public class Vehicle {
	
	private String vehicleName;
	private String vehicleNo;
	
	public Vehicle() {
		super();
	}
	
	public Vehicle(String vehicleName, String vehicleNo) {
		super();
		this.vehicleName = vehicleName;
		this.vehicleNo = vehicleNo;
	}

	public String getVehicleName() {
		return vehicleName;
	}

	public void setVehicleName(String vehicleName) {
		this.vehicleName = vehicleName;
	}

	public String getVehicleNo() {
		return vehicleNo;
	}

	public void setVehicleNo(String vehicleNo) {
		this.vehicleNo = vehicleNo;
	}
	
	
	
}
