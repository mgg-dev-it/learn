package mggdevit.restrequestmapping;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Controller1 {

	@RequestMapping("/control1")
	public String control() {
		return ("Controller 1");
	}

}
