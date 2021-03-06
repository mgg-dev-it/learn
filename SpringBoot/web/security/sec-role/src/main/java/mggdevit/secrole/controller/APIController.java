package mggdevit.secrole.controller;

import org.springframework.security.access.annotation.Secured;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class APIController {

	@RequestMapping("/")
	public String index() {
		return("Main Page");
	}
	
	@Secured("ROLE_USER")
	@RequestMapping("/userpage")
	public String userPage() {
		return("User Page");
	}
	
	@Secured("ROLE_ADMIN")
	@RequestMapping("/adminpage")
	public String adminPage() {
		return("Admin Page");
	}
}
