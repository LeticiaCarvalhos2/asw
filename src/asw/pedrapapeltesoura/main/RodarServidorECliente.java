package asw.pedrapapeltesoura.main;
import java.io.IOException;

import asw.pedrapapeltesoura.cliente.Cliente;
import asw.pedrapapeltesoura.servidor.JogoModel;
import asw.pedrapapeltesoura.servidor.Servidor;
import asw.pedrapapeltesoura.servidor.bot.EstrategiaBotAleatoria;

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
