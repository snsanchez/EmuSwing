package ar.edu.unrn.seminario.exception;

public class JuegoNoEncontradoException extends Exception {

	private static final long serialVersionUID = 1L;

	public JuegoNoEncontradoException(String mensaje) {
		super(mensaje);
	}
}