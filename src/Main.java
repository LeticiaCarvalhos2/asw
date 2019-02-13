import java.util.Random;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {		
		int escolha = -1, moeda = 0;
		Scanner read = new Scanner(System.in);
		Random rd = new Random();
		
		do {
			try {
				System.out.print("Escolha\n0 - Cara\n1 - Coroa\n\n> ");
				escolha = Integer.parseInt(read.nextLine());
				if(escolha != 0 && escolha != 1) {
					System.out.println("Numero incorreto\n");
				}
			}
			catch(NumberFormatException e){
				System.out.println("Formato invalido\n");
			}
		}while(escolha != 0 && escolha != 1);
		
		moeda = rd.nextInt(2);
		
		System.out.printf("O sorteio foi %s", moeda == 0 ? "cara" : "coroa"); 
		System.out.print("\n");
		
		try {
			Thread.sleep(1000);
		}catch(InterruptedException e) {
			
		}
		
		if(escolha == moeda) {
			System.out.println("Ganhou!");
		}else {
			System.out.println("Perdeu!");
		}
		
		read.close();

	}

}
