package mggdevit.restrequestmapping;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Controller2 {

	@RequestMapping("/control2")
	public String control() {
		return ("Controller 2");
	}

}
