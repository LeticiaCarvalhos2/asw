package asw.jogo21.nucleo;

import java.util.List;

public class NucleoJogo {
	private final Mesa mesa;
	private final List<Jogador> jogadores;
	
	public NucleoJogo(List<Jogador> jogadores, Mesa mesa) {
		this.jogadores = jogadores;
		this.mesa = mesa;
	}
	
	public void distribuirCartas() {
		List<List<Carta>> listaCartas = mesa.darCartas(jogadores.size());
		int contador = 0;
		for(Jogador jogador : jogadores) {
			jogador.addCartas(listaCartas.get(contador));
			contador++;
		}
		mesa.addCartas(listaCartas.get(contador));
	}

	public Jogador getVez() {
		return jogadores.get(0);
	}

	public void jogadorDesistir() {
		//jogadores.remove(0);		
	}
	
}
