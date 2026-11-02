package ar.edu.unrn.seminario.exception;
//Representa un fallo en la capa de red debido a la falta de conectividad a internet.
public class SinConexionRedException extends Exception {
	public SinConexionRedException() {
        super();
    }

	public SinConexionRedException(String mensaje) {
        super(mensaje);
    }
}
