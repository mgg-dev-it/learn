package mggdevit.thbasic.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import mggdevit.thbasic.model.Person;

@Controller
public class HomeController {

	private static List<Person> persons = new ArrayList<Person>();
	static {
		persons.add(new Person("John", "Smith"));
		persons.add(new Person("George", "Tailor"));
	}
	
	@RequestMapping("/view")
	public String view(Model model) {
		model.addAttribute("message", "Message");
		model.addAttribute("persons", persons);
		return ("view");
	}


}
