package ar.edu.unrn.seminario.exception;

// en las firmas uso Throwable para poder pasarle cualquier excepción, no solo SQLException sino tambien IOException, IllegalArgumentException, etc. 

public class JuegoDAOException extends RuntimeException {
	private static final long serialVersionUID = 1L;

	private final String codigo;

	public JuegoDAOException(String mensaje, Throwable causa) {
		this(mensaje, null, causa);
	}

	public JuegoDAOException(String mensaje, String codigo, Throwable causa) {
		super(mensaje, causa);
		this.codigo = codigo;
	}

	public String getCodigo() {
		return codigo;
	}
}