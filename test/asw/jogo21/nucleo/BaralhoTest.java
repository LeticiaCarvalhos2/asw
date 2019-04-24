package asw.jogo21.nucleo;

import static org.junit.Assert.assertThat;

import static org.hamcrest.CoreMatchers.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class BaralhoTest {

	private Baralho baralho;

	@BeforeEach
	void setUp() throws Exception {
		baralho = new Baralho();
	}

	@Test
	void tem_52_cartas() {
		assertThat(baralho.tamanho(), is(52));
	}
	
	@Test
	void tem_uma_carta_de_cada_naipe_e_valor() {
		for (Naipe n : Naipe.values()) {
			for (Valor v : Valor.values()) {
				assertThat(baralho.contem(new Carta(n, v)), is(true));
			}
		}
	}
	
}
