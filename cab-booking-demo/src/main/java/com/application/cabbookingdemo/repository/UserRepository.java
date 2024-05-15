package com.application.cabbookingdemo.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.application.cabbookingdemo.entity.User;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
	
	@Query(value = "select * from user u where username=':name'", nativeQuery = true)
	Optional<List<User>> findUserByUsername(String name);
	
}
