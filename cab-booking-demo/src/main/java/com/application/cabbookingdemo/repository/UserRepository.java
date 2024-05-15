package com.application.cabbookingdemo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.application.cabbookingdemo.entity.User;

@Repository
public interface UserRepository extends JpaRepository<User, Long>{
	
}
