import java.io.IOException;
import java.io.PrintStream;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Scanner;

public class Cliente {

	public static void main(String[] args) throws UnknownHostException, IOException {
		System.out.println("Cliente: iniciando");

		String endereco = "localhost";
		int porta = 3233;

		try (Socket cliente = new Socket(endereco, porta);
				Scanner leitorTeclado = new Scanner(System.in);
				PrintStream saidaServidor = new PrintStream(cliente.getOutputStream());
				Scanner leituraServidor = new Scanner(cliente.getInputStream())) {

			System.out.println("Cliente: conectado com sucesso");

			int opcaoInt;
			do {
				System.out.println("Escolha uma opção:");
				for (Opcao o : Opcao.values()) {
					System.out.printf("%d: %s\n", o.ordinal(), o);
				}
				opcaoInt = Integer.parseInt(leitorTeclado.nextLine());
				System.out.println();
			} while (opcaoInt < 0 || opcaoInt >= Opcao.values().length);

			Opcao opcaoJogador = Opcao.valueOf(opcaoInt);
			
			saidaServidor.println(opcaoJogador);
			
			Opcao opcaoMaquina = Opcao.valueOf(leituraServidor.nextLine());

			System.out.printf("Servidor: jogador %s, maquina %s\n", opcaoJogador, opcaoMaquina);
			
			System.out.println(Formatador.resultado(Integer.parseInt(leituraServidor.nextLine())));
		}
	}
}
