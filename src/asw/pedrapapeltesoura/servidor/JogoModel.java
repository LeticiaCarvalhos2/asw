package asw.pedrapapeltesoura.servidor;

import asw.pedrapapeltesoura.comum.dominio.Opcao;

public class JogoModel {
	
	private final Opcao[] opcoes = new Opcao[2];
	
	private int indiceJogador = 0;

	public void escolherOpcao(Opcao opcao) {
		if (indiceJogador >= opcoes.length) {
			throw new IllegalStateException("Opcoes ja foram definidas");
		}
		
		opcoes[indiceJogador++] = opcao;
	}

	public int calcularResultado() {
		if (indiceJogador < opcoes.length) {
			throw new IllegalStateException("Opcoes nao foram todas definidas");
		}
		
		return Opcao.comparar(opcoes[0], opcoes[1]);
	}

}
