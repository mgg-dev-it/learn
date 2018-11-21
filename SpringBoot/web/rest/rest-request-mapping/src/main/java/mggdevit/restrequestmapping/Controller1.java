package mggdevit.restrequestmapping;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
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

	@RequestMapping(value = "/control/{id}", method = RequestMethod.GET)
	public String controlPathVariable(@PathVariable("id") long id) {
		return ("Controller GET with path variable: " + id);
	}

	//the stricter / narrower mapping "wins" - see the simple @RequestMapping(value = "/control", method = RequestMethod.GET) above
	@RequestMapping(value = "/control", params = "id", method = RequestMethod.GET)
	public String controlRequestParam(@RequestParam("id") long id) {
		return ("Controller GET with request param: " + id);
	}

	@RequestMapping("*")
	public String controlFallback() {
		return ("Fallback");
	}

}
