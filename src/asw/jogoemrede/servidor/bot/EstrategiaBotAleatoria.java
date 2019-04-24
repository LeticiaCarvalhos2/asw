package asw.jogoemrede.servidor.bot;

import java.util.Random;

import asw.jogoemrede.comum.dominio.Opcao;

public class EstrategiaBotAleatoria implements EstrategiaBot {

	private final Random random = new Random();
	
	@Override
	public Opcao jogar() {
		return Opcao.valueOf(random.nextInt(Opcao.values().length));
	}

}
