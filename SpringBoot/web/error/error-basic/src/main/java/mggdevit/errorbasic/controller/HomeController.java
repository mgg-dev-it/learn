package mggdevit.errorbasic.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HomeController {

	@RequestMapping("/view")
	public String view() {
		return ("view");
	}

	@RequestMapping("/forcederror")
	public void forcedError() {
		throw new RuntimeException("test exception");
	}

}
