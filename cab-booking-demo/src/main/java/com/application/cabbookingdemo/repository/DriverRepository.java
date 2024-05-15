package com.application.cabbookingdemo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.application.cabbookingdemo.entity.Driver;

@Repository
public interface DriverRepository extends JpaRepository<Driver, Integer> {

}
