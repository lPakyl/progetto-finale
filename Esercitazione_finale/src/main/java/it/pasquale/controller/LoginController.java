package it.pasquale.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class LoginController {
	
	
	@GetMapping("/home")
	public String getLogin() {
		
		return "/home";
	}

}
