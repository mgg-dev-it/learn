package mggdevit.jdbcbasic.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import mggdevit.jdbcbasic.service.ItemServiceInterface;

@Controller
public class Homecontroller {

	@Autowired
	private ItemServiceInterface itemService;

	@GetMapping("/list")
	public String list(Model model) {
		model.addAttribute("items", itemService.getAllItems());
		return ("list");
	}
}
