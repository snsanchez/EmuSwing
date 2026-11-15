package ar.edu.unrn.seminario.exception;

public class PortadaIncorrectaException extends RuntimeException {

	public PortadaIncorrectaException(String mensaje) {
		super(mensaje);
	}

	public PortadaIncorrectaException(String mensaje, Throwable causa) {
		super(mensaje, causa);
	}
}