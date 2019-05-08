package asw.jogo21.nucleo;
import java.util.ArrayList;
import java.util.List;

public class Mesa {
	private final Baralho baralho;
	private final List<Carta>cartas;
	
	public Mesa(Baralho baralho) {
		this.cartas = new ArrayList<>();
		this.baralho = baralho;
	}

	public List<List<Carta>> darCartas(int qtdJogadores) {
		List<List<Carta>> listaCartas = new ArrayList<>();
		
		for(int i = 0; i < qtdJogadores + 1; i++) {
			listaCartas.add(baralho.comprar(2));
		}
		
		return listaCartas;
	}
	
	public List<Carta> getCartas() {
		return cartas;
	}

	public void addCartas(List<Carta> cartas) {
		this.cartas.addAll(cartas);
	}

}
