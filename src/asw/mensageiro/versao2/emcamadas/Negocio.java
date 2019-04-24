package asw.mensageiro.versao2.emcamadas;

import java.io.FileNotFoundException;
import java.io.IOException;

public class Negocio {

	private final Dados dados;

	public Negocio(Dados dados) {
		this.dados = dados;
	}
	
	public boolean criar(String conteudo, String nomeMsg) {
		try {
			dados.criarArquivo(conteudo, nomeMsg);
			return true;
		} catch (IOException e) {
			return false;
		}
	}
	
	public String ler(String nomeMsg) {
		try {
			return dados.lerArquivo(nomeMsg);
		} catch (FileNotFoundException e) {
			return "Arquivo não encontrado!";
		} catch (IOException e) {
			return e.getMessage();
		}
	}

	public boolean deletar(String nomeMsg) {		
		return dados.deletarArquivo(nomeMsg);
	}
	
	public String[] listar() {
		return dados.listarArquivos();
	}
}
