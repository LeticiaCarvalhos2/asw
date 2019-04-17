package asw.mensageiro.versao2.emcamadas;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class Programa {

	public static void main(String[] args) {
		File diretorio = new File(System.getProperty("java.io.tmpdir"), "mensagens");
		
		Apresentacao apresentacao = new Apresentacao(
				new Negocio(new Dados(diretorio)));
		
		apresentacao.exibirMenu();
		
		
		
		try (Scanner scanner = new Scanner(System.in)) {
			String comando = null;
			do {			
				
				apresentacao.lerTeclado();
				String nomeMsg = apresentacao.getNomeMsg();
				comando = apresentacao.getComando();

				
				
				try {

					switch (comando) {
					case "listar":
						for (String mensagem : diretorio.list()) {
							System.out.println(mensagem);
						}
						break;

					case "criar":
						File arquivo = new File(diretorio, nomeMsg);
						arquivo.createNewFile();
						System.out.println("Digite a mensagem e termine com Enter");
						String conteudo = scanner.nextLine();
						try (FileWriter writer = new FileWriter(arquivo)) {
							writer.append(conteudo);
						}
						break;

					case "ler":
						arquivo = new File(diretorio, nomeMsg);
						try (BufferedReader leitor = new BufferedReader(new FileReader(arquivo))) {
							System.out.println(leitor.readLine());
						}
						break;

					case "excluir":
						new File(diretorio, nomeMsg).delete();
						break;

					case "sair":
						break;

					default:
						System.err.print("Comando invalido");
						System.out.println();
					}

				} catch (IOException e) {
					e.printStackTrace();
				}

			} while (comando == null || !comando.equals("sair"));
		}

	}

}
