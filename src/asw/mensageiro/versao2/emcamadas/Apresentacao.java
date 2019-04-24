package asw.mensageiro.versao2.emcamadas;

import java.util.Scanner;

public class Apresentacao {

	private final Negocio negocio;
	private String comando;
	private String nomeMsg;
	
	public Apresentacao(Negocio negocio) {
		this.negocio = negocio;
	}
	
	public void exibirMenu() {
		System.out.println(""
				+ "Comandos validos:\n"
				+ "\tsair\n"
				+ "\tlistar\n"
				+ "\tcriar [nome-da-mensagem]\n"
				+ "\tler [nome-da-mensagem]\n"
				+ "\texcluir [nome-da-mensagem]\n"
				+ "");
	}
	
	public void lerTeclado() {
		Scanner scanner = new Scanner(System.in);
		System.out.print("> ");
		String linhaLida = scanner.nextLine();
		formatarLinhaLida(linhaLida);
	}
	
	private void formatarLinhaLida(String linhaLida) {
		String comando = null;
		String[] palavras = linhaLida.split(" ");
		comando = palavras[0];
		String nomeMsg = null;
		if (palavras.length > 1) nomeMsg = palavras[1];
		this.comando = comando;
		this.nomeMsg = nomeMsg;
	}
	
	public void menu() {
		try (Scanner scanner = new Scanner(System.in)) {
			do {			
				lerTeclado();

				switch (comando) {
				case "listar":
					String[] lista = negocio.listar();
					if(lista.length > 0) {
						for (String mensagem : negocio.listar()) {
							System.out.println(mensagem);
						}
					}
					else {
						System.err.println("Lista Vazia!");
					}
					break;

				case "criar":
					System.out.println("Digite a mensagem e termine com Enter");
					String conteudo = scanner.nextLine();
					if(!negocio.criar(conteudo, nomeMsg)) {
						System.err.println("Erro ao criar Mensagem!");
					}
					else {
						System.out.println("Mensagem criada com Sucesso!");
					}
					break;

				case "ler":
					System.out.println(negocio.ler(nomeMsg));
					break;

				case "excluir":
					if(!negocio.deletar(nomeMsg)) {
						System.err.println("Não foi possível remover a Mensagem!");
					}else {
						System.out.println("Mensagem removida com Sucesso!");
					}
					break;

				case "sair":
					break;

				default:
					System.err.print("Comando invalido");
					System.out.println();
				}

			} while (comando == null || !comando.equals("sair"));
		}
	}
	
	//private void apresentacaoLerteclado() {
}
