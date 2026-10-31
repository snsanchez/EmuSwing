package ar.edu.unrn.seminario.exception;

public class UsuarioExistenteException extends Exception {

    public UsuarioExistenteException(String mensaje) {
        super(mensaje);
    }
}