package com.educandoweb.course.config;

import java.time.Instant;
import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import com.educandoweb.course.entities.Order;
import com.educandoweb.course.entities.User;
import com.educandoweb.course.repositories.OrderRepository;
import com.educandoweb.course.repositories.UserRepository;

@Configuration
@Profile("test")
public class TestConfig implements CommandLineRunner {
	
	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private OrderRepository orderRepository;

	@Override
	public void run(String... args) throws Exception {
		User u1 = new User(null, "Maria Brow", "maria@gmail.com", "9999999", "123456");
		User u2 = new User(null, "Alex Green", "alex@gmail", "997777", "123456");
		
		Order o1 = new Order(null, Instant.parse("2020-04-06T17:00:07Z"), u1);
		Order o2 = new Order(null, Instant.parse("2020-04-07T17:00:07Z"), u2);
		Order o3 = new Order(null, Instant.parse("2020-04-10T17:00:07Z"), u1);
		
		userRepository.saveAll(Arrays.asList(u1, u2));
		orderRepository.saveAll(Arrays.asList(o1,o2,o3));
	    
	}
	
	

}
