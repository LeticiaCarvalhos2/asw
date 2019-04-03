
import java.io.IOException;
import java.io.PrintStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Random;
import java.util.Scanner;

public class Servidor {

	public static void main(String[] args) throws UnknownHostException, IOException {
		System.out.println("Servidor: iniciando");
		
		int porta = 3233;
		
		try (ServerSocket servidor = new ServerSocket(porta)) {
			System.out.println("Servidor: ouvindo porta " + porta);
			
			try (Socket cliente = servidor.accept()) {
				System.out.println("Servidor: conexão de cliente em " + cliente.getInetAddress().getHostAddress());
				
				try (Scanner leitorJogador = new Scanner(cliente.getInputStream())) {
					Opcao opcaoJogador = Opcao.valueOf(leitorJogador.nextLine());
					Opcao opcaoMaquina = Opcao.valueOf(new Random().nextInt(3));
					
					System.out.printf("Servidor: jogador %s, maquina %s\n", opcaoJogador, opcaoMaquina);
					
					try (PrintStream saidaJogador = new PrintStream(cliente.getOutputStream())) {
						saidaJogador.println(opcaoMaquina);
						saidaJogador.println(Opcao.comparar(opcaoJogador, opcaoMaquina));
					}
				}
			}
		}
	}
}
