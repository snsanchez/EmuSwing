package ar.edu.unrn.seminario.exception;

public class UsuarioDAOException extends RuntimeException {

    private static final long serialVersionUID = 1L;

    public UsuarioDAOException(String mensaje, Throwable causa) {
        super(mensaje, causa);
    }
}