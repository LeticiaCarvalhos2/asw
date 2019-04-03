
import java.io.IOException;
import java.io.PrintStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Random;
import java.util.Scanner;

public class Servidor {

	public static void main(String[] args) throws UnknownHostException, IOException {
		// Conexão
		System.out.println("Servidor");
		ServerSocket servidor = new ServerSocket(3233);
		System.out.println("Porta 3233 aberta!");

		// Aguardando cliente
		Socket cliente = servidor.accept();
		System.out.println("Nova conexão com o cliente " + cliente.getInetAddress().getHostAddress());

		// Recebendo escolha de jogada
		Scanner leitorJogador = new Scanner(cliente.getInputStream());
		Opcao opcaoJogador = Opcao.getOpcao(leitorJogador.nextInt());

		// Escolha maquina randomica
		Opcao opcaoMaquina = Opcao.getOpcao(new Random().nextInt(3));
		System.out.println(opcaoMaquina);

		// Enviando dados
		PrintStream saida = new PrintStream(cliente.getOutputStream());
		
		saida.println(opcaoMaquina);
		saida.println(Opcao.comparar(opcaoJogador, opcaoMaquina));

		saida.close();
		leitorJogador.close();
		servidor.close();
		cliente.close();
	}
}
