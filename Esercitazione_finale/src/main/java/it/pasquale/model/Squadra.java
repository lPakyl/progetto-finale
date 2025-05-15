package it.pasquale.model;

import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;

@Entity
public class Squadra {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_squadra")
	private int id;

	private String nome;
	private int anni;
	private int titoli;
	private String presidente;

	@OneToMany(mappedBy = "squadra")
	private List<Giocatore> giocatori;

	public Squadra() {

		giocatori = new ArrayList<>();
	}

	public Squadra(String nome, int anni, int titoli, String presidente) {

		this.nome = nome;
		this.anni = anni;
		this.titoli = titoli;
		this.presidente = presidente;
		giocatori = new ArrayList<>();
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public int getAnni() {
		return anni;
	}

	public void setAnni(int anni) {
		this.anni = anni;
	}

	public int getTitoli() {
		return titoli;
	}

	public void setTitoli(int titoli) {
		this.titoli = titoli;
	}

	public String getPresidente() {
		return presidente;
	}

	public void setPresidente(String presidente) {
		this.presidente = presidente;
	}

	public List<Giocatore> getGiocatori() {
		return giocatori;
	}

	public void setGiocatori(List<Giocatore> giocatori) {
		this.giocatori = giocatori;
	}

	public int getId() {
		return id;
	}

	@Override
	public String toString() {
		return "Squadra [id=" + id + ", nome=" + nome + ", anni=" + anni + ", titoli=" + titoli + ", presidente="
				+ presidente + "]";
	}

}
