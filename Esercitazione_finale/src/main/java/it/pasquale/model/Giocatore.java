package it.pasquale.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

@Entity
public class Giocatore {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_giocatore")
	private int id;

	@NotNull
	@Size(min = 4, max = 20)
	private String nome;

	@NotNull
	@Size(min = 4, max = 20)
	private String cognome;

	@NotNull
	@Min(2)
	private int anni;

	@NotNull
	@Size(min = 6, max = 25)
	private String nazionalita;
	
	@NotNull
	@Size(min = 4, max = 20)
	private String ruolo;

	@ManyToOne
	@JoinColumn(name = "fk_squadra", referencedColumnName = "id_squadra")
	private Squadra squadra;

	public Giocatore() {
	}

	public Giocatore(String nome, String cognome, int anni, String nazionalita, String ruolo) {
		this.nome = nome;
		this.cognome = cognome;
		this.anni = anni;
		this.nazionalita = nazionalita;
		this.ruolo = ruolo;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getCognome() {
		return cognome;
	}

	public void setCognome(String cognome) {
		this.cognome = cognome;
	}

	public int getAnni() {
		return anni;
	}

	public void setAnni(int anni) {
		this.anni = anni;
	}

	public String getNazionalita() {
		return nazionalita;
	}

	public void setNazionalita(String nazionalita) {
		this.nazionalita = nazionalita;
	}

	public Squadra getSquadra() {
		return squadra;
	}

	public void setSquadra(Squadra squadra) {
		this.squadra = squadra;
	}
	
	public String getRuolo() {
		return ruolo;
	}
	
	public void setRuolo(String ruolo) {
		this.ruolo = ruolo;
	}

	public int getId() {
		return id;
	}

	@Override
	public String toString() {
		return "Giocatore [id=" + id + ", nome=" + nome + ", cognome=" + cognome + ", anni=" + anni + ", nazionalita="
				+ nazionalita + ", ruolo=" + ruolo + "]";
	}

	

}
