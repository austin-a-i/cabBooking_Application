package com.application.cabbookingdemo.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.test.context.SpringBootTest;

import com.application.cabbookingdemo.entity.User;
import com.application.cabbookingdemo.repository.UserRepository;
import com.application.cabbookingdemo.services.UserService;

@ExtendWith(MockitoExtension.class)
public class UserServiceTest {
	private Logger log = LoggerFactory.getLogger(this.getClass());
	
	@Mock
	private UserRepository userRepository;
	
	@InjectMocks
	private UserService userService;
	
	@Test
	void testFindByName() {
		when(userRepository.findUserByUsername("Rahul")).thenReturn(new Optional<List<User>>1002, "Rahul" , 'M', 29));
		log.info(user.toString());
		assertEquals("Rahul", user.get());
	}
	
	@Test
	void testSaveUser() {
		
	}
	
	
}
