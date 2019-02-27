import java.io.IOException;
import java.io.PrintStream;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Scanner;

public class Cliente {

	public static void main(String[] args) throws UnknownHostException, IOException {
		//Conexão com server
		System.out.println("Cliente");
		Socket cliente = new Socket("127.0.0.1", 3233);		
			
		System.out.println("O cliente se conectou ao servidor!");

		//Enviando dados
        Scanner teclado = new Scanner(System.in);
        PrintStream saida = new PrintStream(cliente.getOutputStream());
        
        //Cliente digita escolha de jogada
        int escolha = -1;
	      do {
	        System.out.println("Selecione\n 0 - Papel \n 1 - Pedra \n 2 - Tesoura");
	        escolha = Integer.parseInt(teclado.nextLine()); 
	      }while(escolha < 0 || escolha >= 3); 
	        saida.println(escolha);

        // Recebendo escolha da máquina
        Scanner msg = new Scanner(cliente.getInputStream());
        System.out.println(msg.nextLine());
        
        System.out.println(msg.nextLine());
        
        msg.close();
        saida.close();
        teclado.close();
        cliente.close();
	}

}
