package mggdevit.secdbauth;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/*
 * SanFranciscobolJottem
 * 
 * Spring Boot II. 17. Spring Security - DB Authentication
 * 
 */

/*
 * https://springframework.guru/using-the-h2-database-console-in-spring-boot-with-spring-security/
 * 
 * https://www.logicbig.com/tutorials/spring-framework/spring-boot/jdbc-security-with-h2-console.html
 * 
 * http://www.virtual7.de/blog/2018/04/spring-security-authentication-using-locally-stored-h2-database/
 * 
 * https://grokonez.com/spring-framework/spring-security/configure-spring-security-access-h2-database-console-spring-boot-project
 * 
 */

@SpringBootApplication
public class SecDbAuthApplication {

	public static void main(String[] args) {
		SpringApplication.run(SecDbAuthApplication.class, args);
	}

}

