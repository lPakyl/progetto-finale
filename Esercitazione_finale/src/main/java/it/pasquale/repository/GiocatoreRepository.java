package it.pasquale.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import it.pasquale.model.Giocatore;
@Repository
public interface GiocatoreRepository extends JpaRepository<Giocatore, Integer>{
	
	@Query("SELECT g FROM Giocatore g WHERE g.ruolo = 'Attaccante'")
	Optional<Giocatore> findAttaccanti(String ruolo);

	Optional<Giocatore> findByNome(String nome);

}
