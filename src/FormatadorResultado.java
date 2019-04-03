public class FormatadorResultado {

	public static String formatar(int comparacao) {
		return comparacao < 0 ? "Perdeu" :
			comparacao == 0 ? "Empatou" : "Ganhou";
	}
	
}
