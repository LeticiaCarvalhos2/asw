package asw.jogo21.nucleo;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Baralho {

	private final List<Carta> cartas = new ArrayList<>();
	
	public Baralho() {
		for (Naipe n : Naipe.values()) {
			for (Valor v : Valor.values()) {
				cartas.add(new Carta(n, v));
			}
		}
		
		Collections.shuffle(cartas);
	}
	
	public int tamanho() {
		return cartas.size();
	}

	public boolean contem(Carta c) {
		return cartas.contains(c);
	}

}
