import java.util.Random;
import java.util.Scanner;

public class Jogo {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		
		int escolha = -1;
		
		do {
			try {
				System.out.print("Escolha\n0 - Pedra\n1 - Papel\n2 - Tesoura\n\n> ");
				escolha = Integer.parseInt(scanner.nextLine());
				if (escolha < 0 || escolha >= 3) {
					System.out.println("Numero incorreto\n");
				}
			} catch (NumberFormatException e) {
				System.out.println("Formato invalido\n");
			}
		} while (escolha < 0 || escolha >= 3);

		Opcao escolhaJogador = Opcao.getOpcao(escolha),
				escolhaMaquina = Opcao.getOpcao(new Random().nextInt(3));
		
		System.out.println(escolhaMaquina);
		System.out.println(Formatador.resultado(
				Opcao.comparar(escolhaJogador, escolhaMaquina)));

		scanner.close();
	}
}
