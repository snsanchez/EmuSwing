package ar.edu.unrn.seminario.modelo;

import java.util.Objects;

public class Suscripcion {
	//Nombre de la suscripcion,
	private String nombre;  
	
	//Costo de la suscripcion.
	private float costo;   
	
	//Constructor
	public Suscripcion(String nombre, float costo) {  
		this.nombre = nombre;
		this.costo = costo;
	}

	//getters and setters
	public String getNombre() {  
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public float getCosto() {
		return costo;
	}

	public void setCosto(float costo) {
		this.costo = costo;
	}

	//HashCode and equals
	@Override
	public int hashCode() {
		return Objects.hash(costo, nombre);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Suscripcion other = (Suscripcion) obj;
		return Float.floatToIntBits(costo) == Float.floatToIntBits(other.costo) && Objects.equals(nombre, other.nombre);
	}
	
	//toString
	@Override
	public String toString() {
		return "Suscripcion: " + nombre + " -Costo: " + costo;
	}

}
