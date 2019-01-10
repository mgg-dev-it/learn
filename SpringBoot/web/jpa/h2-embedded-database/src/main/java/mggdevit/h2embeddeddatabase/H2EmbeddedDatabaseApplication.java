package mggdevit.h2embeddeddatabase;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/*
 * driver = org.h2.Driver
 * url    = jdbc:h2:mem:testdb
 * user   = sa
 * pw     = <empty> 
 * 
 */

@SpringBootApplication
public class H2EmbeddedDatabaseApplication {

	public static void main(String[] args) {
		SpringApplication.run(H2EmbeddedDatabaseApplication.class, args);
	}

}

