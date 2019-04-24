package asw.mensageiro.versao2.emcamadas;

import java.io.File;

public class Programa {

	public static void main(String[] args) {
		File diretorio = new File(System.getProperty("java.io.tmpdir"), "mensagens");
		
		Apresentacao apresentacao = new Apresentacao(
				new Negocio(new Dados(diretorio)));
		
		apresentacao.menu();
	}

}
