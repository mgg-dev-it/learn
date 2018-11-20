package mggdevit.resthelloworld;

import org.springframework.boot.SpringApplication;
//import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
//import org.springframework.context.annotation.ComponentScan;
//import org.springframework.context.annotation.Configuration;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
//@EnableAutoConfiguration
//@ComponentScan
//@Configuration
@RestController //@Controller + @ResponseBody -> Spring treats the result of the request handler methods as the response itself
public class RestHelloWorldApplication {

	public static void main(String[] args) {
		SpringApplication.run(RestHelloWorldApplication.class, args);
	}

	@RequestMapping(value = "/")
	public String hello() {
		return "Hello World :)";
	}
	
	//https://docs.spring.io/spring-framework/docs/current/javadoc-api/org/springframework/web/bind/annotation/RestController.html
	//https://www.baeldung.com/spring-controller-vs-restcontroller
	
}
