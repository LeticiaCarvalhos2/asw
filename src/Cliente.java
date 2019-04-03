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
				System.out.println("Selecione\n 0 - Pedra \n 1 - Papel\n 2 - Tesoura");
				opcaoInt = Integer.parseInt(leitorTeclado.nextLine());
			} while (opcaoInt < 0 || opcaoInt >= 3);

			saidaServidor.println(Opcao.valueOf(opcaoInt));

			System.out.println(Formatador.escolhaMaquina(Opcao.valueOf(leituraServidor.nextLine())));
			System.out.println(Formatador.resultado(Integer.parseInt(leituraServidor.nextLine())));
		}
	}
}
