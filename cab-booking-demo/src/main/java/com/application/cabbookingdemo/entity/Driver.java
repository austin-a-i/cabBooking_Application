package com.application.cabbookingdemo.entity;

import org.hibernate.annotations.Where;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Column;
import jakarta.persistence.Embedded;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Where(clause = "is_available = true")
public class Driver {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    
    @Column(name = "drivername", nullable = false)
    private String driverName;
    
    @Enumerated(EnumType.STRING)
	private Sex sex;
    
    @Embedded
    private Vehicle vehicle;
    
    private boolean isAvailable;
    
    @Embedded
    @Column(name = "currentlocation", nullable = false)
    @JsonIgnore
    private Location location;
    
    
}
