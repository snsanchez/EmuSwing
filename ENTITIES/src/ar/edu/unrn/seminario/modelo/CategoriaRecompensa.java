package ar.edu.unrn.seminario.modelo;

import java.util.Objects;

public class CategoriaRecompensa {
    private int codigo;
    private String nombre;
    private String descripcion;
    private String codigoColorHex; // Ej: "#FFD700" para usar en Swing con Color.decode()

    
    public CategoriaRecompensa(int codigo, String nombre, String descripcion, String codigoColorHex) {
        this.codigo = codigo;
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.codigoColorHex = codigoColorHex;
    }

   //Constructor solo con codigo
    public CategoriaRecompensa(int codigo) {
        this.codigo = codigo;
    }

    
    // Getters y Setters
    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getCodigoColorHex() {
        return codigoColorHex;
    }

    public void setCodigoColorHex(String codigoColorHex) {
        this.codigoColorHex = codigoColorHex;
    }

    @Override
    public String toString() {
        return this.nombre; 
    }

    @Override
    public int hashCode() {
        return Objects.hash(codigo);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        CategoriaRecompensa otra = (CategoriaRecompensa) obj;
        return this.codigo == otra.codigo;
    }
}