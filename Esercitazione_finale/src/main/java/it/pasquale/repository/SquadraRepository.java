package it.pasquale.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import it.pasquale.model.Squadra;
@Repository
public interface SquadraRepository extends JpaRepository<Squadra, Integer>{
	
	public Optional<Squadra> findByNome(String nome);
}
