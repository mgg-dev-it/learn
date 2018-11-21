package mggdevit.restrequestmapping;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Controller1 {

	@RequestMapping("/control1")
	public String control1() {
		return ("Controller 1");
	}

	@RequestMapping(value = "/control", method = RequestMethod.GET)
	public String controlGET() {
		return ("Controller GET");
	}
	
	@RequestMapping(value = "/control", method = RequestMethod.POST)
	public String controlPOST() {
		return ("Controller POST");
	}
	
}
