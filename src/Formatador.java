public class Formatador {

	public static String resultado(int comparacao) {
		return comparacao < 0 ? "Derrota" :
			comparacao == 0 ? "Empate" : "Vitória";
	}

	public static String escolhaMaquina(Opcao opcao) {
		return "Máquina jogou " + opcao;
	}
	
}
