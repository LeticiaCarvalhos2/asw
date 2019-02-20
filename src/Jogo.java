import java.util.Random;
import java.util.Scanner;

public class Jogo {
	
	

	public static void main(String[] args) {		
		int escolha = -1, escolhaMaquina = 0;
		Scanner read = new Scanner(System.in);
		Random rd = new Random();
		
		do {
			try {
				System.out.print("Escolha\n0 - Pedra\n1 - Papel\n2 - Tesoura\n\n> ");
				escolha = Integer.parseInt(read.nextLine());
				if(escolha < 0 || escolha >=3) {
					System.out.println("Numero incorreto\n");
				}
			}
			catch(NumberFormatException e){
				System.out.println("Formato invalido\n");
			}
		}while(escolha < 0 || escolha >= 3);
		
		escolhaMaquina = rd.nextInt(3);
		
		if(escolhaMaquina == 0) {
			System.out.println("Máquina jogou Pedra\n");
			if(escolha == 0) {
				System.out.println("Empate\n");
			}else if(escolha == 1) {
				System.out.println("Vitória\n");
			}
			else {
				System.out.println("Derrota\n");
			}
		}else if(escolhaMaquina == 1) {
			System.out.println("Máquina jogou Papel\n");
			if(escolha == 0) {
				System.out.println("Derrota\n");
			}else if(escolha == 1) {
				System.out.println("Empate\n");
			}
			else {
				System.out.println("Vitória\n");
			}
		}else {
			System.out.println("Máquina jogou Tesoura\n");
			if(escolha == 0) {
				System.out.println("Vitória\n");
			}else if(escolha == 1) {
				System.out.println("Derrota\n");
			}
			else {
				System.out.println("Empate\n");
			}
		}
		
		
		
		read.close();

	}

}
