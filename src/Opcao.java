public enum Opcao {
	PEDRA, PAPEL, TESOURA;

	public static Opcao getOpcao(int codigo) {
		return Opcao.values()[codigo];
	}

	public static String ganhaDe(Opcao jogador, Opcao maquina) {
		if (jogador == maquina) {
			return "Empate";
		} else if ((jogador == Opcao.PEDRA && maquina == Opcao.TESOURA)
				|| (jogador == Opcao.TESOURA && maquina == Opcao.PAPEL)
				|| (jogador == Opcao.PAPEL && maquina == Opcao.PEDRA)) {
			return "Venceu";
		} else {
			return "Perdeu";
		}
	}

}
