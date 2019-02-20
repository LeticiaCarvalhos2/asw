import java.io.IOException;
import java.io.PrintStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Scanner;

public class Servidor {

	public static void main(String[] args) throws UnknownHostException, IOException{
			//Conexão
			System.out.println("Servidor");
			ServerSocket servidor = new ServerSocket(3233);
			System.out.println("Porta 3233 aberta!");
			
			//Aguardando cliente
			Socket cliente = servidor.accept();
			System.out.println("Nova conexão com o cliente " +     
		            cliente.getInetAddress().getHostAddress()
		    );
			
			//Recebendo dados
			Scanner s = new Scanner(cliente.getInputStream());
	        System.out.println(s.nextLine());
	        
	        //Enviando dados
	        PrintStream saida = new PrintStream(cliente.getOutputStream());
	        saida.println("Mensagem Recebida!");
	        
	        Scanner teclado = new Scanner(System.in);
	        saida.println(teclado.next());
	        
	        System.out.println(s.nextLine());
	        
	        s.close();
	        servidor.close();
	        cliente.close();
	}
}
