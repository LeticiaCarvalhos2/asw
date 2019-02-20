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
        
        //Cliente digita mensagem
        System.out.println("Selecione\n 1 - Papel \n 2 - Pedra \n 3 - Tesoura");
        saida.println(teclado.nextLine());

        // Recebendo dados
        Scanner msg = new Scanner(cliente.getInputStream());
        System.out.println(msg.nextLine());
        
        System.out.println(msg.nextLine());
        
        saida.println("Cliente Recebeu");
        
        saida.close();
        teclado.close();
        cliente.close();
	}

}
