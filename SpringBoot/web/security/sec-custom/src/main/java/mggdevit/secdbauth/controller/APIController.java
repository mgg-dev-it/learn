package mggdevit.secdbauth.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

//@RestController
@Controller
public class APIController {

	@RequestMapping("/")
	public String root() {
		return ("index");
	}

	@RequestMapping("/index")
	public String index() {
		return ("index");
	}

	@RequestMapping("/login")
	public String login() {
		return ("login");
	}

//	@RequestMapping("/logout")
//	public String logout() {
//		return ("login?logout");
//	}

	@RequestMapping("/logout")
	public String logout(Model model) {
		model.addAttribute("logout", true);
		return ("login");
	}
	
}
