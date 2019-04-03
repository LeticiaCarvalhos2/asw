package main;
import java.io.IOException;

import cliente.Cliente;
import servidor.Servidor;
import servidor.bot.EstrategiaBotAleatoria;

public class RodarServidorECliente {

	public static void main(String[] args) throws IOException {
		int porta = 3233;

		try (Servidor servidor = new Servidor(porta, new EstrategiaBotAleatoria())) {
			servidor.start();
			new Cliente("localhost", porta);
		}
	}

}
