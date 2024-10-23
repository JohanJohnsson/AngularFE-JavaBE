package org.example.angularfejavabe;

import org.example.angularfejavabe.model.User;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.example.angularfejavabe.repo.UserRepository;

import java.util.stream.Stream;

@SpringBootApplication
public class AngularFeJavaBeApplication {

	public static void main(String[] args) {
		SpringApplication.run(AngularFeJavaBeApplication.class, args);
	}

	@Bean
	CommandLineRunner init(UserRepository userRepository) {
		return args -> {
			Stream.of("Adam", "John", "Anna", "Johan", "Felix").forEach(name -> {
				User user = new User(name, name.toLowerCase() + "@domain.com");
				userRepository.save(user);
			});
			userRepository.findAll().forEach(System.out::println);
		};
	}
}
