package asw.mensageiro.versao2.emcamadas;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class Dados {
	private File diretorio;
	
	Dados(File diretorio) {
		this.diretorio = diretorio;
		this.diretorio.mkdir();
	}
	
	public void criarArquivo(String conteudo, String nomeMsg) throws IOException{
		
		File arquivo = new File(diretorio, nomeMsg);
		arquivo.createNewFile();
		
		try (FileWriter writer = new FileWriter(arquivo)) {
			writer.append(conteudo);
		}
	}
	
	public String lerArquivo(String nomeMsg) throws FileNotFoundException, IOException {
		File arquivo = new File(diretorio, nomeMsg);
		try (BufferedReader leitor = new BufferedReader(new FileReader(arquivo))) {
			return leitor.readLine();
		}
	}

	public boolean deletarArquivo(String nomeMsg) {
		return new File(diretorio, nomeMsg).delete();		
	}
	
	public String[] listarArquivos() {
		return diretorio.list();
	}
}
