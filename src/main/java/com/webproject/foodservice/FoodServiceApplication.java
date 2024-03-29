package com.webproject.foodservice;

import com.webproject.foodservice.DAO.UserRepository;
import com.webproject.foodservice.entity.Role;
import com.webproject.foodservice.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@SpringBootApplication
public class FoodServiceApplication implements CommandLineRunner {

	@Autowired
	private UserRepository userRepository;

	public static void main(String[] args) {
		SpringApplication.run(FoodServiceApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {

		User adminAccount = userRepository.findByRole(Role.ADMIN);
		if(adminAccount == null) {
			User user = new User();

			user.setEmail("admin@gmail.com");
			user.setFirst_name("admin");
			user.setSecond_name("admin");
			user.setRole(Role.ADMIN);
			user.setPassword(new BCryptPasswordEncoder().encode("admin"));
			userRepository.save(user);
		}
	}
}
