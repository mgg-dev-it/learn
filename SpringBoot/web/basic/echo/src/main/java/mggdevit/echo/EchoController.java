package mggdevit.echo;

import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class EchoController {

	@RequestMapping(value = "/")
	public String echoRoot() {
		// String sHTML = "This is the Echo webapp.";
		String sHTML = """
				<!DOCTYPE html>
				<html>
					<head>
						<title>Echo webapp</title>
					</head>
					<body>
						<h1>This is the Echo webapp.</h1>
						<h3>How to use it:</h3>
					</body>
				</html>
				""";
		return sHTML;
	}

	@RequestMapping("/echo")
	public String echoEcho() {
		return ("echo");
	}

	@RequestMapping("/echo/json")
	public String echoEchoJSON(@RequestBody String sJSON) {
		return (sJSON);
	}
	
	@RequestMapping("*")
	public String echoFallback() {
		return ("Fallback");
	}

}
