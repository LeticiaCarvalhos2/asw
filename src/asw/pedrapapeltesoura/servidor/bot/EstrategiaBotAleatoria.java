package asw.pedrapapeltesoura.servidor.bot;

import java.util.Random;

import asw.pedrapapeltesoura.comum.dominio.Opcao;

public class EstrategiaBotAleatoria implements EstrategiaBot {

	private final Random random = new Random();
	
	@Override
	public Opcao jogar() {
		return Opcao.valueOf(random.nextInt(Opcao.values().length));
	}

}
