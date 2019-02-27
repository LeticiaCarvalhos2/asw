
public enum Opcoes {
	PEDRA(0), PAPEL(1), TESOURA(2);

	Opcoes(int opcao){
		
	}
	
	public static Opcoes getOpcoes(int valor) {
		return Opcoes.values()[valor];
	}
	
	public static String ganhaDe(Opcoes jogador, Opcoes maquina) {
		if(jogador == maquina) {
			return "Empate";
		}
		else if((jogador == Opcoes.PEDRA && maquina == Opcoes.TESOURA) ||
				(jogador == Opcoes.TESOURA && maquina == Opcoes.PAPEL) ||
				(jogador == Opcoes.PAPEL && maquina == Opcoes.PEDRA)
				) {
			return "Venceu";
		}
		else {
			return "Perdeu";
		}
	}
	
}
