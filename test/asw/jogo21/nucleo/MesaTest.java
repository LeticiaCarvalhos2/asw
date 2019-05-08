package asw.jogo21.nucleo;

import static org.junit.Assert.assertThat;

import java.util.List;

import static org.hamcrest.CoreMatchers.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class MesaTest {

	private Mesa mesa;

	@BeforeEach
	void setUp() throws Exception {
		mesa = new Mesa(new Baralho(
				new Carta(Naipe.COPAS, Valor.AS),
				new Carta(Naipe.COPAS, Valor.DOIS),
				new Carta(Naipe.ESPADAS, Valor.TRES),
				new Carta(Naipe.ESPADAS, Valor.QUATRO),
				new Carta(Naipe.OUROS, Valor.CINCO),
				new Carta(Naipe.OUROS, Valor.SEIS)
				));
	}

	@Test
	void da_duas_cartas_por_jogador_mais_duas_para_propria_mesa() {
		assertThat(mesa.darCartas(2), is(
				List.of(
						List.of(new Carta(Naipe.OUROS, Valor.SEIS),
								new Carta(Naipe.OUROS, Valor.CINCO)),
						
						List.of(new Carta(Naipe.ESPADAS, Valor.QUATRO),
								new Carta(Naipe.ESPADAS, Valor.TRES)),
						
						List.of(new Carta(Naipe.COPAS, Valor.DOIS),
								new Carta(Naipe.COPAS, Valor.AS))
				)));
	}
	
}
