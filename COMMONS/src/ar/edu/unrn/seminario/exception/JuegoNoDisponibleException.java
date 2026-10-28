package ar.edu.unrn.seminario.exception;

public class JuegoNoDisponibleException extends Exception {
	public JuegoNoDisponibleException() {
        super();
    }

	public JuegoNoDisponibleException(String mensaje) {
        super(mensaje);
    }
}
