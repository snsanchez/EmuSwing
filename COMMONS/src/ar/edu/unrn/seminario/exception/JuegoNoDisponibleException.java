package ar.edu.unrn.seminario.exception;
//Excepción de comprobada que representa la imposibilidad de acceder o cargar un título específico seleccionado.
public class JuegoNoDisponibleException extends Exception {		
	public JuegoNoDisponibleException() {	//El archivo de la ROM no existe físicamente, fue movido o la ruta está corrupta.
        super();
    }

	public JuegoNoDisponibleException(String mensaje) {
        super(mensaje);
    }
}
