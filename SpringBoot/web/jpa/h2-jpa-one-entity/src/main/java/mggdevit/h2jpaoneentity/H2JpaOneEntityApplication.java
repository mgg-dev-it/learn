package mggdevit.h2jpaoneentity;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/*
 * jdbc:h2:mem:testdb
 * sa
 * <empty> 
 * 
 */

@SpringBootApplication
public class H2JpaOneEntityApplication {

	public static void main(String[] args) {
		SpringApplication.run(H2JpaOneEntityApplication.class, args);
	}

}

