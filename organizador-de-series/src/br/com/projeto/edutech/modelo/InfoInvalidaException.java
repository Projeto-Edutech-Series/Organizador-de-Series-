package br.com.projeto.edutech.modelo;

public class InfoInvalidaException extends RuntimeException {

	private static final long serialVersionUID = 3800356975496002772L;

	public InfoInvalidaException() {

	}

	public InfoInvalidaException(String message) {
		super(message);
	}

}
