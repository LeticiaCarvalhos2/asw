package asw.mensageiro.versao2.emcamadas;

import java.io.FileNotFoundException;
import java.io.IOException;

public class Negocio {

	private final Dados dados;

	public Negocio(Dados dados) {
		this.dados = dados;
	}
	
	public void criar(String conteudo, String nomeMsg) throws MensagemInvalidaException, ErroInesperadoException{
			
		try {
			if(conteudo.length() <= 30) {
				dados.criarArquivo(conteudo, nomeMsg);
			}else {	
				throw new MensagemInvalidaException(conteudo.length());
			}
		} catch (IOException e) {
			throw new ErroInesperadoException(e);
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
