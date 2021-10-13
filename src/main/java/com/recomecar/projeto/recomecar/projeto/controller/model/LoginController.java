package com.recomecar.projeto.recomecar.projeto.controller.model;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class LoginController {
	@GetMapping("/loginpage")
	public String index() {
		return "loginpage";
	}

}
