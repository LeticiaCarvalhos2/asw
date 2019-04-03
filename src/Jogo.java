import java.util.Random;
import java.util.Scanner;

public class Jogo {

	public static void main(String[] args) {
		Opcoes escolhaJogador, escolhaMaquina;
		int escolha = -1;
		Scanner read = new Scanner(System.in);
		Random rd = new Random();

		do {
			try {
				System.out.print("Escolha\n0 - Pedra\n1 - Papel\n2 - Tesoura\n\n> ");
				escolha = Integer.parseInt(read.nextLine());
				if (escolha < 0 || escolha >= 3) {
					System.out.println("Numero incorreto\n");
				}
			} catch (NumberFormatException e) {
				System.out.println("Formato invalido\n");
			}
		} while (escolha < 0 || escolha >= 3);

		escolhaJogador = Opcoes.getOpcoes(escolha);
		escolhaMaquina = Opcoes.getOpcoes(rd.nextInt(3));

		System.out.println(escolhaMaquina);
		System.out.println(Opcoes.ganhaDe(escolhaJogador, escolhaMaquina));

		read.close();
	}
}
