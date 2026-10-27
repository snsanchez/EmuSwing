package ar.edu.unrn.seminario.exception;

public class CatalogoVacioException extends Exception {
	
	public CatalogoVacioException() {
		
	}
	
	public CatalogoVacioException(String mensaje) {
		super(mensaje);
	}

}
