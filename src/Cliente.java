import java.io.IOException;
import java.io.PrintStream;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Scanner;

public class Cliente {

	public static void main(String[] args) throws UnknownHostException, IOException {
		// Conexão com server
		System.out.println("Cliente");
		try (Socket cliente = new Socket("127.0.0.1", 3233)) {
			
			System.out.println("O cliente se conectou ao servidor!");
			
			// Enviando dados
			try (Scanner teclado = new Scanner(System.in);
					PrintStream saida = new PrintStream(cliente.getOutputStream())) {
				
				// Cliente digita escolha de jogada
				int escolha = -1;
				do {
					System.out.println("Selecione\n 0 - Pedra \n 1 - Papel\n 2 - Tesoura");
					escolha = Integer.parseInt(teclado.nextLine());
				} while (escolha < 0 || escolha >= 3);
				saida.println(escolha);
				
				// Recebendo escolha da máquina
				try (Scanner msg = new Scanner(cliente.getInputStream())) {
					System.out.println(Formatador.escolhaMaquina(Opcao.valueOf(msg.nextLine())));
					System.out.println(Formatador.resultado(Integer.parseInt(msg.nextLine())));
				}
			}
		}
	}
}
