package com.application.cabbookingdemo.dtos.requests;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class RideRequestDTO {
	
	private String name;
	private String source;
	private String destination;
	
}
