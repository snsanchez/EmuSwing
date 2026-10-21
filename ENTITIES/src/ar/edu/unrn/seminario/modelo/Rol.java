package ar.edu.unrn.seminario.modelo;

public class Rol {
	private Integer codigo;
	private String nombre;
	private boolean activo;

	public Rol() {

	}

	public Rol(Integer codigo, String nombre) {
		super();
		this.codigo = codigo;
		this.nombre = nombre;
	}

	public Integer getCodigo() {
		return codigo;
	}

	public void setCodigo(Integer codigo) {
		this.codigo = codigo;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public boolean isActivo() {
		return activo;
	}

	public void setActivo(boolean activo) {
		this.activo = activo;
	}

	public void activar() {
		this.activo = true;
	}

	public void desactivar() {
		this.activo = false;
	}

	@Override
	public int hashCode() {
		return codigo;
	}

	@Override
	public boolean equals(Rol ) {

	}

	@Override
	public String toString() {
		return "Rol: " + nombre;
	}

}
