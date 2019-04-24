package asw.jogoemrede.main;
import java.io.IOException;

import asw.jogoemrede.cliente.Cliente;
import asw.jogoemrede.servidor.JogoModel;
import asw.jogoemrede.servidor.Servidor;
import asw.jogoemrede.servidor.bot.EstrategiaBotAleatoria;

public class RodarServidorECliente {

	public static void main(String[] args) throws IOException {
		int porta = 3233;

		try (Servidor servidor = new Servidor(porta, new JogoModel(),
				new EstrategiaBotAleatoria())) {
			servidor.start();
			new Cliente("localhost", porta);
		}
	}

}
