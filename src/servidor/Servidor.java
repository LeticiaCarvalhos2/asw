package servidor;
import java.io.Closeable;
import java.io.IOException;
import java.io.PrintStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

import comum.dominio.Opcao;
import servidor.bot.EstrategiaBot;

public class Servidor extends Thread implements Closeable {

	private final ServerSocket serverSocket;
	private final EstrategiaBot estrategiaBot;

	public Servidor(int porta, EstrategiaBot estrategiaBot) throws IOException {
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

			saidaJogador.println(opcaoMaquina);
			saidaJogador.println(Opcao.comparar(opcaoJogador, opcaoMaquina));

		} catch (IOException e) {
			throw new RuntimeException(e);
		}
	}

	@Override
	public void close() throws IOException {
		serverSocket.close();
	}

}
