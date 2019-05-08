package asw.jogo21.nucleo;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Baralho {

	private final List<Carta> cartas;
	
	public Baralho() {
		cartas = new ArrayList<>();
		for (Naipe n : Naipe.values()) {
			for (Valor v : Valor.values()) {
				cartas.add(new Carta(n, v));
			}
		}
		
		Collections.shuffle(cartas);
	}
	
	public Baralho(Carta... cartas) {
		this.cartas = new ArrayList<>(List.of(cartas));
	}

	public int tamanho() {
		return cartas.size();
	}

	public boolean contem(Carta c) {
		return cartas.contains(c);
	}

	public List<Carta> comprar(int quantidade) {
		List<Carta> entrega = new ArrayList<>();
		for(int i = 0; i < quantidade; i++){
			entrega.add(cartas.get(cartas.size() - 1));
			cartas.remove(cartas.size() - 1);
		}
		
		return entrega;
	}

}
