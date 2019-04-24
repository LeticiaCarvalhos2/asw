package asw.jogoemrede.servidor;

import java.io.Closeable;
import java.io.IOException;
import java.io.PrintStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

import asw.jogoemrede.comum.dominio.Opcao;
import asw.jogoemrede.servidor.bot.EstrategiaBot;

public class Servidor extends Thread implements Closeable {

	private final JogoModel jogoModel;
	private final EstrategiaBot estrategiaBot;
	
	private final ServerSocket serverSocket;

	public Servidor(int porta, JogoModel jogoModel,
			EstrategiaBot estrategiaBot) throws IOException {
		this.jogoModel = jogoModel;
		this.estrategiaBot = estrategiaBot;
		
		System.out.println("Servidor: iniciando");
		
		serverSocket = new ServerSocket(porta);
	}

	public void run() {
		System.out.println("Servidor: ouvindo porta " + serverSocket.getLocalPort());

		try (Socket cliente = serverSocket.accept();
				Scanner leitorJogador = new Scanner(cliente.getInputStream());
				PrintStream saidaJogador = new PrintStream(cliente.getOutputStream())) {
			
			System.out.println("Servidor: conexão de cliente em " +
				cliente.getInetAddress().getHostAddress());

			Opcao opcaoJogador = Opcao.valueOf(leitorJogador.nextLine()),
					opcaoMaquina = estrategiaBot.jogar();

			System.out.printf("Servidor: jogador %s, maquina %s\n",
					opcaoJogador, opcaoMaquina);

			jogoModel.escolherOpcao(opcaoJogador);
			jogoModel.escolherOpcao(opcaoMaquina);
			
			saidaJogador.println(opcaoMaquina);
			saidaJogador.println(jogoModel.calcularResultado());

		} catch (IOException e) {
			throw new RuntimeException(e);
		}
	}

	@Override
	public void close() throws IOException {
		serverSocket.close();
	}

}
