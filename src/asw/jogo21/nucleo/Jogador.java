package asw.jogo21.nucleo;

import java.util.List;

public class Jogador {

	private final String nome;
	private final List<Carta> cartas;

	public Jogador(String nome, List<Carta> cartas) {
		this.nome = nome;
		this.cartas = cartas;
	}

	public String getNome() {
		return nome;
	}

	public List<Carta> getCartas() {
		return cartas;
	}
	
	public void addCartas(List<Carta> cartas) {
		this.cartas.addAll(cartas);
	}

}
