package ar.edu.unrn.seminario.modelo;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class CatalogoDeLogros {
	
	private List<Logro> logros; 

	public CatalogoDeLogros() {
		this.logros = new ArrayList<>();
	}

	public CatalogoDeLogros(List<Logro> logros) {
		this.logros = logros;
	}

	public void agregarLogro(Logro logro) {
		this.logros.add(logro);
	}

	public Logro obtenerLogroPorCategoria(String categoria) {
		for (Logro logro : this.logros) {
			if (logro.getCategoria().equalsIgnoreCase(categoria)) {
				return logro; 
			}
		}
		return null;
	}

	public Logro buscarLogroPorID(int id) {
		for (Logro logro : this.logros) {
			if (logro.getId() == id) {
				return logro;
			}
		}
		return null;
	}

	@Override
	public String toString() {
		return "CatalogoDeLogros [logros=" + logros + "]";
	}

	@Override
	public int hashCode() {
		return Objects.hash(logros);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		CatalogoDeLogros other = (CatalogoDeLogros) obj;
		return Objects.equals(logros, other.logros);
	}
}