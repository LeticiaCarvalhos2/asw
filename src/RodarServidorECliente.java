import java.io.IOException;

public class RodarServidorECliente {

	public static void main(String[] args) throws IOException {
		int porta = 3233;

		try (Servidor servidor = new Servidor(porta)) {
			servidor.start();
			new Cliente("localhost", porta);
		}
	}

}
