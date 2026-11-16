package ar.edu.unrn.seminario.exception;

public class RolNoEncontradoException extends RuntimeException {
    public RolNoEncontradoException(String mensaje) {
        super(mensaje);
    }
}