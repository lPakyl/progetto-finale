package it.pasquale.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import it.pasquale.model.Giocatore;
import it.pasquale.repository.GiocatoreRepository;

@Service
public class GiocatoreService {

	private GiocatoreRepository giocatoreRepository;

	public GiocatoreService(GiocatoreRepository giocatoreRepository) {
		this.giocatoreRepository = giocatoreRepository;
	}

	public List<Giocatore> getGiocatori() {

		return this.giocatoreRepository.findAll();
	}
	
	public void aggiungiGiocatore(Giocatore giocatore) {
		this.giocatoreRepository.save(giocatore);
	}

	public Giocatore getSquadraById(int id) throws IllegalStateException {

		Optional<Giocatore> giocatoreTrovato = this.giocatoreRepository.findById(id);

		if (!giocatoreTrovato.isPresent())
			throw new IllegalStateException("Il giocatore non è presente nel DB!");
		return giocatoreTrovato.get();
	}

	public Giocatore getGiocatoreByRuolo(String ruolo) throws IllegalStateException {

		Optional<Giocatore> giocatoreTrovato = this.giocatoreRepository.findAttaccanti(ruolo);

		if (!giocatoreTrovato.isPresent())
			throw new IllegalStateException("Giocatore non presente nel DB!");
		return giocatoreTrovato.get();
	}

	public void deleteGiocatore(int id) {
		this.giocatoreRepository.deleteById(id);
	}

	public void updateAnniGiocatori(int id, int anni) throws IllegalStateException {

		Giocatore giocatore = this.giocatoreRepository.findById(id).orElse(null);

		if (giocatore == null)
			throw new IllegalStateException("Giocatore non presente nel DB!");

		giocatore.setAnni(anni);
		this.giocatoreRepository.save(giocatore);
	}

	/*public void aggiungiGiocatore(Giocatore giocatore) throws IllegalStateException {

		Optional<Giocatore> giocatoreTrovato = this.giocatoreRepository.findByNome(giocatore.getNome());

		if (giocatoreTrovato.isPresent())
			throw new IllegalStateException("Giocatore già presente!");
		this.giocatoreRepository.save(giocatore);
	}*/

}
