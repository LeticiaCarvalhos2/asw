package asw.mensageiro.versao2.emcamadas;

import java.io.File;

public class Dados {
	private File diretorio;
	
	Dados(File diretorio) {
		this.diretorio = diretorio;
		this.diretorio.mkdir();
	}
	
	
}
