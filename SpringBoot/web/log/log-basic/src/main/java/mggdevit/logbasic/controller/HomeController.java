package mggdevit.logbasic.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HomeController {

	Logger logger = LoggerFactory.getLogger(HomeController.class);

	@RequestMapping("/list")
	public String list() {
		logger.info("list called");
		return ("list");
	}
}
