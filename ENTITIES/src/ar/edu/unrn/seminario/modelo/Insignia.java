package ar.edu.unrn.seminario.modelo;

import java.util.Objects;

public class Insignia {
	//nombre de la insignia
	private String nombre;  
	
	//Cantidad de logros requeridos para la insignia. 
	private Integer cantLogrosReq; 
	
	//Constructor
	public Insignia(String nombre, Integer cantLogrosReq) { 
		this.nombre = nombre; 
		this.cantLogrosReq = cantLogrosReq;
	}
	
	//toString
	@Override
	public String toString() {
		return "Insignia: " + nombre + " -Logros requeridos: " + cantLogrosReq;
	}

	//hashCode and equals
	@Override
	public int hashCode() {
		return Objects.hash(cantLogrosReq, nombre);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Insignia other = (Insignia) obj;
		return Objects.equals(cantLogrosReq, other.cantLogrosReq) && Objects.equals(nombre, other.nombre);
	}

	//getters and setters
	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public Integer getCantLogrosReq() {
		return cantLogrosReq;
	}

	public void setCantLogrosReq(Integer cantLogrosReq) {
		this.cantLogrosReq = cantLogrosReq;
	}
}



