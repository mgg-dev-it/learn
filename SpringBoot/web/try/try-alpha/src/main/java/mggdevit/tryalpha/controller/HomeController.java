package mggdevit.tryalpha.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import mggdevit.tryalpha.model.Person;

@Controller
public class HomeController {

	private static List<Person> persons = new ArrayList<Person>();
	static {
		persons.add(new Person("John", "Smith"));
		persons.add(new Person("George", "Tailor"));
	}
	
//	@RequestMapping("/")
//	public String index() {
//		return ("index");
//	}

	@RequestMapping("/tmp")
	public String tmp() {
		return ("tmp");
	}

	@RequestMapping("/view")
	public String view(Map<String, Object> model) {
		model.put("message", "foo");
		return ("view");
	}

	@RequestMapping("/personlist")
	public String personlist(Model model) {
		model.addAttribute("persons", persons);
		return ("personlist");
	}
	
	// https://www.mkyong.com/spring-boot/spring-boot-hello-world-example-thymeleaf/
	// https://spring.io/guides/gs/serving-web-content/
	// https://www.baeldung.com/spring-boot-crud-thymeleaf
	// https://o7planning.org/en/11545/spring-boot-and-thymeleaf-tutorial
}
