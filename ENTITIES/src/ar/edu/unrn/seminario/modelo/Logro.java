package ar.edu.unrn.seminario.modelo;

public class Logro {
	private Integer id;
	private String titulo;
	private String descripcion;
	private Integer puntos;
	private String categoria;
	
	
	public Logro() {
		
	}
	
	public Logro(Integer id, String titulo, String descripcion, Integer puntos, String categoria) {
		this.id = id;
		this.titulo = titulo;
		this.descripcion = descripcion;
		this.puntos = puntos;
		this.categoria = categoria;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public Integer getPuntos() {
		return puntos;
	}

	public void setPuntos(Integer puntos) {
		this.puntos = puntos;
	}

	public String getCategoria() {
		return categoria;
	}

	public void setCategoria(String categoria) {
		this.categoria = categoria;
	}
	
	@Override
	public String toString() {
		return "Logro [id=" + id + ", titulo=" + titulo + ", descripcion=" + descripcion 
				+ ", puntos=" + puntos + ", categoria=" + categoria + "]";
	}

	@Override
	public int hashCode() {
		// Generamos el hash basado en el identificador único
		return java.util.Objects.hash(id);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Logro other = (Logro) obj;
		return java.util.Objects.equals(id, other.id);
	}
	
}
