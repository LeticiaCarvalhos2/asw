package asw.mensageiro.versao2.emcamadas;

public class MensagemInvalidaException extends Exception {

	/**
	 * 
	 */
	public MensagemInvalidaException(int tamanho) {
		this.tamanho = tamanho; 
	}
	
	private static final long serialVersionUID = 1L;
	private int tamanho;
	
	public int getTamanho() {
		return tamanho;
	}
}
