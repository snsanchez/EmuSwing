package ar.edu.unrn.seminario.exception;

public class SinConexionRedException extends Exception {
	public SinConexionRedException() {
        super();
    }

	public SinConexionRedException(String mensaje) {
        super(mensaje);
    }
}
