package it.pasquale.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import it.pasquale.model.Giocatore;
import it.pasquale.service.GiocatoreService;
import jakarta.validation.Valid;

@Controller
public class GiocatoreController {
	
	private GiocatoreService giocatoreService;
	@Autowired
	
	
	public GiocatoreController(GiocatoreService giocatoreService) {
		this.giocatoreService = giocatoreService;
		
	}
	
	@GetMapping("/giocatore")
	public String mostraForm(Giocatore giocatori) {
		return "form";
	}
	
	@PostMapping("/giocatore")
	public String giocaotriInfo(@Valid Giocatore giocatore, BindingResult bindingResult) {
		
		if(bindingResult.hasErrors()) {
			return "form";
		}
		giocatoreService.aggiungiGiocatore(giocatore);
		
		return "completato";
	}
	
	
	
	
}
