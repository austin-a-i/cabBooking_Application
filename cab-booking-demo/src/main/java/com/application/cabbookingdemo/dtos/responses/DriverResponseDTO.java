package com.application.cabbookingdemo.dtos.responses;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class DriverResponseDTO {

	private long id;
    private String drivername;
    
    private String statusCode;
    private String statusMessage;
}
