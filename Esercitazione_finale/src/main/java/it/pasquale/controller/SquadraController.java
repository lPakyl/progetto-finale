package it.pasquale.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import it.pasquale.service.SquadraService;

@Controller
@RequestMapping("/squadra")
public class SquadraController {
	
	private SquadraService squadraService;
	
	public SquadraController(SquadraService squadraService) {
		this.squadraService = squadraService;
	}
	
	@GetMapping
	public String getSquadra(Model model) {
		
		model.addAttribute("squadra", this.squadraService.getSquadra());
		
		return "lista-squadra";
	}

}
