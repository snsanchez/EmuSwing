package ar.edu.unrn.seminario.exception;

public class ConexionBaseDeDatosException extends RuntimeException{
	
	public ConexionBaseDeDatosException() {
		
	}
	
	public ConexionBaseDeDatosException(String mensaje) {
		super(mensaje);
	}
}
