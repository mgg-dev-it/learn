package mggdevit.jdbcbasic;

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
public class JdbcBasicApplication {

	public static void main(String[] args) {
		SpringApplication.run(JdbcBasicApplication.class, args);
	}
	
	//http://www.springboottutorial.com/spring-boot-and-spring-jdbc-with-h2
	//http://www.springboottutorial.com/spring-boot-and-h2-in-memory-database
	//http://www.h2database.com/html/cheatSheet.html
	//http://www.h2database.com/html/features.html
	

}

