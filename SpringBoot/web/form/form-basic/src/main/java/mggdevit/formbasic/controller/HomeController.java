package mggdevit.formbasic.controller;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import mggdevit.formbasic.model.Person;

@Controller
public class HomeController {

//	private static List<Person> persons = new ArrayList<Person>();
//	static {
//		persons.add(new Person("John", "Smith"));
//		persons.add(new Person("George", "Tailor"));
//	}
	
	@GetMapping("/form")
	public String formGet(Model model) {
		//model.addAttribute("persons", persons);
		//Person person = new Person();
		//model.addAttribute("person", person);
		model.addAttribute("person", new Person());
		return ("form");
	}


	@PostMapping("/form")
	public String formPost(@ModelAttribute @Valid Person person, Errors errors) {
//		System.out.println("---");
//		System.out.println(person.getFirstName());
//		System.out.println(person.getLastName());
		return ("form");
	}
	
	
}
