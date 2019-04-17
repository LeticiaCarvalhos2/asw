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
	
	
	
	public String getComando() {
		return comando;
	}
	public String getNomeMsg() {
		return nomeMsg;
	}
	//private void apresentacaoLerteclado() {
}
