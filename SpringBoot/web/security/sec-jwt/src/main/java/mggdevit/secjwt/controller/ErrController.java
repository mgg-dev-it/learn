package mggdevit.secjwt.controller;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.error.ErrorAttributeOptions;
import org.springframework.boot.web.servlet.error.ErrorAttributes;
import org.springframework.boot.web.servlet.error.ErrorController;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.ServletWebRequest;

@RestController
public class ErrController implements ErrorController {

	private static final String ERR_PATH = "/error";

	private ErrorAttributes errorAttributes;

	@Autowired
	public void setErrorAttributes(ErrorAttributes errorAttributes) {
		this.errorAttributes = errorAttributes;

	}

	@RequestMapping(ERR_PATH)
	public String error(Model model, HttpServletRequest request) {
		// RequestAttributes requestAttributes = new ServletRequestAttributes(request);
		// Map<String, Object> errorMap =
		// this.errorAttributes.getErrorAttributes(requestAttributes, true);
		ServletWebRequest servletWebRequest = new ServletWebRequest(request);
		// Map<String, Object> errorAttributes =
		// this.errorAttributes.getErrorAttributes(servletWebRequest, true);
		Map<String, Object> errorAttributes = this.errorAttributes.getErrorAttributes(servletWebRequest, ErrorAttributeOptions.defaults());

		model.addAttribute("timestamp", errorAttributes.get("timestamp"));
		model.addAttribute("status", errorAttributes.get("status"));
		model.addAttribute("error", errorAttributes.get("error"));
		model.addAttribute("message", errorAttributes.get("message"));
		model.addAttribute("trace", errorAttributes.get("trace"));
		model.addAttribute("path", errorAttributes.get("path"));

		if (errorAttributes.get("status").toString().equalsIgnoreCase("401")) {
			return ("error401page");
		}

		if (errorAttributes.get("status").toString().equalsIgnoreCase("403")) {
			return ("error403page");
		}

		if (errorAttributes.get("status").toString().equalsIgnoreCase("404")) {
			return ("error404page");
		}

		return ("errorpage " + errorAttributes.get("status").toString());
	}

	@Override
	public String getErrorPath() {
		return (ERR_PATH);
	}

}
