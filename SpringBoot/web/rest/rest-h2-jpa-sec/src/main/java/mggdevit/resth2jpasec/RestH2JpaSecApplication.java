package mggdevit.resth2jpasec;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import mggdevit.resth2jpasec.domain.Car;
import mggdevit.resth2jpasec.domain.CarRepository;
import mggdevit.resth2jpasec.domain.Owner;
import mggdevit.resth2jpasec.domain.OwnerRepository;
import mggdevit.resth2jpasec.domain.User;
import mggdevit.resth2jpasec.domain.UserRepository;

/*
 * Based on the 3rd and 4th chapter of the book "Hands-On Full Stack Development with Spring Boot 2.0 and React" by Juha Hinkula
 */

@SpringBootApplication
public class RestH2JpaSecApplication {

	@Autowired
	private CarRepository repository;

	@Autowired
	private OwnerRepository orepository;

	@Autowired
	private UserRepository urepository;

	public static void main(String[] args) {
		SpringApplication.run(RestH2JpaSecApplication.class, args);
	}

	@Bean
	CommandLineRunner runner() {
		return args -> {
			Owner owner1 = new Owner("John", "Johnson");
			Owner owner2 = new Owner("Mary", "Robinson");
			orepository.save(owner1);
			orepository.save(owner2);

			repository.save(new Car("Ford", "Mustang", "Red", "ADF-1121", 2017, 59000, owner1));
			repository.save(new Car("Nissan", "Leaf", "White", "SSJ-3002", 2014, 29000, owner2));
			repository.save(new Car("Toyota", "Prius", "Silver", "KKO-0212", 2018, 39000, owner2));

			urepository.save(new User("user", "$2a$04$1.YhMIgNX/8TkCKGFUONWO1waedKhQ5KrnB30fl0Q01QKqmzLf.Zi", "USER")); // username: user password: user
			urepository.save(new User("admin", "$2a$04$KNLUwOWHVQZVpXyMBNc7JOzbLiBjb9Tk9bP7KNcPI12ICuvzXQQKG", "ADMIN")); // username: admin password: admin
		};
	}
}
