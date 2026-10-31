package ar.edu.unrn.seminario.modelo;

public class Rol {
	private Integer codigo;
	private String nombre;
	private boolean activo;

	public Rol(Integer codigo, String nombre) {
		this.codigo = codigo;
		this.nombre = nombre;
		this.activo = true;
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

	public void activar() {
		this.activo = true;
	}

	public void desactivar() {
		this.activo = false;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null || getClass() != obj.getClass())
			return false;
		Rol rol = (Rol) obj;
		return codigo != null && codigo.equals(rol.codigo);
	}

	@Override
	public int hashCode() {
		return codigo != null ? codigo.hashCode() : 0;
	}
}