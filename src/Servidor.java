import java.io.Closeable;
import java.io.IOException;
import java.io.PrintStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Random;
import java.util.Scanner;

public class Servidor extends Thread implements Closeable {

	private final ServerSocket serverSocket;

	public Servidor(int porta) throws IOException {
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
					opcaoMaquina = Opcao.valueOf(new Random().nextInt(3));

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
