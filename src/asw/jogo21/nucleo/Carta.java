package asw.jogo21.nucleo;

public class Carta {

	private final Naipe naipe;
	private final Valor valor;

	public Carta(Naipe naipe, Valor valor) {
		this.naipe = naipe;
		this.valor = valor;
	}

	@Override
	public int hashCode() {
		return naipe.hashCode() + valor.hashCode();
	}

	@Override
	public boolean equals(Object outro) {
		if (!(outro instanceof Carta)) return false;
		
		Carta outra = (Carta) outro;
		
		return naipe.equals(outra.naipe) && valor.equals(outra.valor);
	}
	
	@Override
	public String toString() {
		return valor + "-de-" + naipe;
	}
	
}
