package asw.jogoemrede.comum.dominio;

public enum Opcao {
	PEDRA, PAPEL, TESOURA;

	public static Opcao valueOf(int codigo) {
		return Opcao.values()[codigo];
	}

	public static int comparar(Opcao opc1, Opcao opc2) {
		if (opc1 == opc2) {
			return 0;
		} else if ((opc1 == Opcao.PEDRA && opc2 == Opcao.TESOURA)
				|| (opc1 == Opcao.TESOURA && opc2 == Opcao.PAPEL)
				|| (opc1 == Opcao.PAPEL && opc2 == Opcao.PEDRA)) {
			return +1;
		} else {
			return -1;
		}
	}

}
