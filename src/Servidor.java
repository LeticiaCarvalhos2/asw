
import java.io.IOException;
import java.io.PrintStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Random;
import java.util.Scanner;

public class Servidor {

	public static void main(String[] args) throws UnknownHostException, IOException {
		int porta = 3233;
		
		System.out.println("Servidor");
		
		try (ServerSocket servidor = new ServerSocket(porta)) {
			System.out.println("Porta " + porta + " aberta!");
			
			try (Socket cliente = servidor.accept()) {
				System.out.println("Nova conexão com o cliente " + cliente.getInetAddress().getHostAddress());
				
				try (Scanner leitorJogador = new Scanner(cliente.getInputStream())) {
					Opcao opcaoJogador = Opcao.getOpcao(leitorJogador.nextInt());
					
					Opcao opcaoMaquina = Opcao.getOpcao(new Random().nextInt(3));
					System.out.println(opcaoMaquina);
					
					try (PrintStream saida = new PrintStream(cliente.getOutputStream())) {
						saida.println(opcaoMaquina);
						saida.println(Opcao.comparar(opcaoJogador, opcaoMaquina));
					}
				}
			}
		}
	}
}
