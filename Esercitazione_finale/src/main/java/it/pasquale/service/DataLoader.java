package it.pasquale.service;

import java.util.List;

import org.springframework.stereotype.Service;

import it.pasquale.model.Squadra;
import it.pasquale.repository.SquadraRepository;
import jakarta.annotation.PostConstruct;

@Service
public class DataLoader {

	private SquadraRepository squadraRepository;
	
	public DataLoader(SquadraRepository squadraRepository) {
		this.squadraRepository = squadraRepository;
	}
	
	@PostConstruct
	private void loadData() {
		
		Squadra squadra = new Squadra("Juventus", 127, 70, "Gianluca Ferrero");
		Squadra squadra1 = new Squadra("Real Madrid", 120, 99, "Florentino Pérez");
		
		squadraRepository.saveAll(List.of(squadra, squadra1));

	}
	
}
