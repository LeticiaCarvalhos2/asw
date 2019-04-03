
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
			
			try (Socket cliente = servidor.accept();
					Scanner leitorJogador = new Scanner(cliente.getInputStream());
					PrintStream saidaJogador = new PrintStream(cliente.getOutputStream())) {
				System.out.println("Servidor: conexão de cliente em " + cliente.getInetAddress().getHostAddress());
				
				Opcao opcaoJogador = Opcao.valueOf(leitorJogador.nextLine()),
						opcaoMaquina = Opcao.valueOf(new Random().nextInt(3));
				
				System.out.printf("Servidor: jogador %s, maquina %s\n", opcaoJogador, opcaoMaquina);
				
				saidaJogador.println(opcaoMaquina);
				saidaJogador.println(Opcao.comparar(opcaoJogador, opcaoMaquina));
			}
		}
	}
}
