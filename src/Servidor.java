// ESTA COM ERRO

import java.io.IOException;
import java.io.PrintStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Random;
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
			
			//Recebendo escolha de jogada
			int escolhido = 0;
			Scanner s = new Scanner(cliente.getInputStream());
	        escolhido = s.nextInt();
	        
	        // Escolha maquina randomica
	        int escolhaMaquina;
	        Random rd = new Random();
	        escolhaMaquina = rd.nextInt(3);
	        System.out.println(escolhaMaquina);
	        
	        //Enviando dados
	        PrintStream saida = new PrintStream(cliente.getOutputStream());
	        if(escolhaMaquina == 0) {
	        	saida.println("Máquina jogou Papel\\n");
	        	saida = new PrintStream(cliente.getOutputStream());
				if(escolhido == escolhaMaquina) {
					saida.println("Empate\n");
				}else if(escolhido == 2) {
					saida.println("Vitória\n");
				}
				else if (escolhido == 1){
					saida.println("Derrota\n");
				}
			}else if(escolhaMaquina == 1) {
				saida.println("Máquina jogou Pedra\n");
				saida = new PrintStream(cliente.getOutputStream());
				if(escolhido == 0) {
					saida.println("Derrota\n");
				}else if(escolhido == 1) {
					saida.println("Empate\n");
				}
				else {
					saida.println("Vitória\n");
				}
			}else if(escolhaMaquina == 2){
				saida.println("Máquina jogou Tesoura\n");
				saida = new PrintStream(cliente.getOutputStream());
				if(escolhido == 0) {
					saida.println("Vitória\n");
				}else if(escolhido == 1) {
					saida.println("Derrota\n");
				}
				else {
					saida.println("Empate\n");
				}
			}
	        
	        s.close();
	        servidor.close();
	        cliente.close();
	}
}
