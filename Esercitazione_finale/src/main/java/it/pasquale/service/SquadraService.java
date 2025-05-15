package it.pasquale.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import it.pasquale.model.Squadra;
import it.pasquale.repository.SquadraRepository;

@Service
public class SquadraService {
	
	private SquadraRepository sqaudraRepository;
	
	public SquadraService(SquadraRepository squadraRepository) {
		this.sqaudraRepository = squadraRepository;
	}
	
	public List<Squadra> getSquadra() {
		
		return this.sqaudraRepository.findAll();
	}
	
	public void deleteSquadra(int id) {
		this.sqaudraRepository.deleteById(id);
	}
	
	public void updateTitoliSquadra(int id, int titoli) throws IllegalStateException{
		
		Squadra squadra = this.sqaudraRepository.findById(id).orElse(null);
		
		if(squadra == null)
				throw new IllegalStateException("Squadra non presente nel DB!");
		
		squadra.setTitoli(titoli);
		this.sqaudraRepository.save(squadra);
	}
	
	public Squadra getSquadraById(int id) throws IllegalStateException{
		
		Optional<Squadra> squadraTrovata = this.sqaudraRepository.findById(id);
		
		if(!squadraTrovata.isPresent())
				throw new IllegalStateException("Squadra non presente nel DB!");
		return squadraTrovata.get();
	}
	
	public void aggiungiSquadra(Squadra squadra) throws IllegalStateException{
		
		Optional<Squadra> squadraTrovata = this.sqaudraRepository.findByNome(squadra.getNome());
		
		if(squadraTrovata.isPresent())
				throw new IllegalStateException("Squadra già presente!");
		this.sqaudraRepository.save(squadra);
	}
	
	
	
}
