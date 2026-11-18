package ar.edu.unrn.seminario.exception;

public class RegistroJuegoDAOException extends RuntimeException {
	
	    private static final long serialVersionUID = 1L;

	    private final String codigo;

	    public RegistroJuegoDAOException(String mensaje, Throwable causa) {
	        this(mensaje, null, causa);
	    }

	    public RegistroJuegoDAOException(String mensaje, String codigo, Throwable causa) {
	        super(mensaje, causa);
	        this.codigo = codigo;
	    }

	    public String getCodigo() {
	        return codigo;
	    }
	}

