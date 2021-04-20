package mggdevit.scope.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import mggdevit.scope.bean.Bean1;

@Controller
public class HomeController {

	@Autowired
	private Bean1 bean1;

	@RequestMapping("/")
	public String index(Model model, HttpServletRequest request) {
		model.addAttribute("message", "Message");
//		model.addAttribute("sessionid", request.getSession().getId());
		model.addAttribute("sessionid", ""+request.getSession().getCreationTime());
		model.addAttribute("bean1counter", "" + bean1.getCounter());
		model.addAttribute("bean1nextcounter", "" + bean1.getNextCounter());
		return ("index");
	}

}
