package asw.mensageiro.versao2.emcamadas;

import java.util.Scanner;

public class Apresentacao {

	private final Negocio negocio;
	private String comando;
	private String nomeMsg;
	
	public Apresentacao(Negocio negocio) {
		this.negocio = negocio;
	}
	
	private void exibirOpcoes() {
		System.out.println(""
				+ "Comandos validos:\n"
				+ "\tsair\n"
				+ "\tlistar\n"
				+ "\tcriar [nome-da-mensagem]\n"
				+ "\tler [nome-da-mensagem]\n"
				+ "\texcluir [nome-da-mensagem]\n"
				+ "");		
	}
	
	public void lerTeclado(Scanner scanner) {		
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
		exibirOpcoes();
		try (Scanner scanner = new Scanner(System.in)) {
			do {			
				lerTeclado(scanner);

				switch (comando) {
				case "listar":
					listar();
					break;

				case "criar":
					criar(scanner);
					break;

				case "ler":
					ler();
					break;

				case "excluir":
					excluir();
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

	private void ler() {
		System.out.println(negocio.ler(nomeMsg));
	}

	private void excluir() {
		if(!negocio.deletar(nomeMsg)) {
			System.err.println("Não foi possível remover a Mensagem!");
		}else {
			System.out.println("Mensagem removida com Sucesso!");
		}
	}

	private void criar(Scanner scanner) {
		System.out.println("Digite a mensagem e termine com Enter");
		String conteudo = scanner.nextLine();
		try {
			negocio.criar(conteudo, nomeMsg);
			System.out.println("Mensagem criada com Sucesso!");
		}
		catch(ErroInesperadoException e) {
			System.err.println("Erro ao criar Mensagem!");
		}
		catch(MensagemInvalidaException e) {
			System.err.println("Tamanho da Mensagem excedido! Limite é de 30 caracteres!\nTamanho da sua Mensagem: " + e.getTamanho());
		}
	}

	private void listar() {
		String[] lista = negocio.listar();
		if(lista.length > 0) {
			for (String mensagem : negocio.listar()) {
				System.out.println(mensagem);
			}
		}
		else {
			System.err.println("Lista Vazia!");
		}
	}
	
	//private void apresentacaoLerteclado() {
}
