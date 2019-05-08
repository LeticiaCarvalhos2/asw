package asw.jogo21.nucleo;

import static org.junit.Assert.assertThat;

import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.CoreMatchers.*;

import org.junit.Ignore;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class NucleoJogoTest {

	private NucleoJogo nucleo;
	private Baralho baralho;
	private Mesa mesa;
	
	private Jogador jose;
	private Jogador maria;
	private Jogador paulo;
	
	private Carta as;
	private Carta dois;
	private Carta tres;
	private Carta quatro;
	private Carta cinco;
	private Carta seis;
	private Carta sete;

	@BeforeEach
	void setUp() {
		jose = new Jogador("Jose", new ArrayList<>());
		maria = new Jogador("Maria", new ArrayList<>());
		paulo = new Jogador("Paulo", new ArrayList<>());
		
		as = new Carta(Naipe.COPAS, Valor.AS);
		dois = new Carta(Naipe.COPAS, Valor.DOIS);
		tres = new Carta(Naipe.ESPADAS, Valor.TRES);
		quatro = new Carta(Naipe.ESPADAS, Valor.QUATRO);
		cinco = new Carta(Naipe.OUROS, Valor.CINCO);
		seis = new Carta(Naipe.OUROS, Valor.SEIS);
		sete = new Carta(Naipe.PAUS, Valor.SETE);

		baralho = new Baralho(as, dois, tres, quatro, cinco, seis, sete);
		mesa = new Mesa(baralho);
		
		nucleo = new NucleoJogo(List.of(jose, maria, paulo), mesa);
		
		nucleo.distribuirCartas();
	}
	
	@Test
	void distribui_cartas_para_jogadores_e_mesa() {
		assertThat(baralho.tamanho(), is(1));
		assertThat(jose.getCartas(), is(List.of(sete, seis)));
		assertThat(maria.getCartas(), is(List.of(cinco, quatro)));
		assertThat(mesa.getCartas(), is(List.of(tres, dois)));
	}
	
	@Test
	void vez_comeca_no_primeiro_jogador() {
		assertThat(nucleo.getVez(), is(jose));
	}
	
	@Test
	void ao_desistir_jogador_nao_joga_mais_e_muda_vez_para_proximo() {
		nucleo.jogadorDesistir();
		assertThat(nucleo.getVez(), is(maria));
	}
	
	@Test
	@Ignore
	void ao_pedir_carta_jogador_ganha_mais_uma_e_muda_vez_para_proximo() {
		
	}
	
}
