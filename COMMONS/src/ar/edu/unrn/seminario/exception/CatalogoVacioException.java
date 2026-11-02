package ar.edu.unrn.seminario.exception;

public class CatalogoVacioException extends Exception {
	
	public CatalogoVacioException() {			//Cuando se intenta acceder, filtrar o mostrar una lista de juegos que no tiene elementos.
		
	}
	
	public CatalogoVacioException(String mensaje) {
		super(mensaje);
	}

}
